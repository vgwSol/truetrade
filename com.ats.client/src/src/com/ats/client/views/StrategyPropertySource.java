package com.ats.client.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.ats.db.PlatformDAO;
import com.ats.engine.StrategyDefinition;
import com.ats.platform.TimeSpan;

public class StrategyPropertySource implements IPropertySource {
	private StrategyDefinition stratDef;
	private TimeSpan defSpan;
	private IPropertyDescriptor propertyDescriptors[];
	
	public StrategyPropertySource(StrategyDefinition def) {
		stratDef = def;
		defSpan = stratDef.getBacktestDataTimeSpan();
	}

	public Object getEditableValue() {
		return this;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		if( propertyDescriptors == null ) {
			List<IPropertyDescriptor> pdList = new ArrayList<IPropertyDescriptor>(10);
			// span values
			String spanValues[] = new String[TimeSpan.values().length];
			for( int i = 0; i < TimeSpan.values().length; i++ ) {
				spanValues[i] = TimeSpan.values()[i].toString();
			}
			ComboBoxPropertyDescriptor spanPD = new ComboBoxPropertyDescriptor("timeSpan", "Backtest TimeSpan", spanValues);
			spanPD.setCategory("Basic");
			pdList.add(spanPD);
			
			PropertyDescriptor classPD = new PropertyDescriptor("stratClass", "Strategy Class");
			classPD.setLabelProvider(new LabelProvider() {
				public String getText(Object element) {
					return element.toString();
//					Class clazz = (Class)element;
//					return clazz.getCanonicalName();
				}
			});
			classPD.setDescription("Simple class name of strategy.");
			classPD.setCategory("Basic");
			pdList.add(classPD);
			
			for( String paramKey : stratDef.getParameterNames() ) {
				TextPropertyDescriptor tpd = new TextPropertyDescriptor("param_" + paramKey, paramKey);
				tpd.setCategory("Parameters");
				pdList.add(tpd);
			}
			
			propertyDescriptors = new IPropertyDescriptor[pdList.size()];
			pdList.toArray(propertyDescriptors);
		}
		return propertyDescriptors;
	}

	public Object getPropertyValue(Object id) {
		if( ((String)id).startsWith("param_") ) {
			String key = ((String)id).substring(6);
			return stratDef.getParameter(key);
		} else if(id.equals("timeSpan")) {
			// Combo box has to return the index of the selection
//			return stratDef.getBacktestDataTimeSpan().toString();
			return stratDef.getBacktestDataTimeSpanId();
//			return Arrays.asList(TimeSpan.values()).indexOf(stratDef.getBacktestDataTimeSpan());
		} else if( id.equals("stratClass")) {
			return stratDef.getStrategyClassName();
		} 
		return null;
	}

	public boolean isPropertySet(Object id) {
		return true;
	}

	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {
		boolean isDirty = false;
		if( ((String)id).startsWith("param_") ) {
			String key = ((String)id).substring(6);
			stratDef.setParameter(key, (Number)value);
			isDirty = true;
		} else if( id.equals("timeSpan")) {
			stratDef.setBacktestDataTimeSpan(TimeSpan.values()[(Integer)value]);
			isDirty = true;
		} else if( "PARAM".equals(id)) {
			// strategyParamSource.setParams((Parameters)value);
		}
		if( isDirty ) {
			PlatformDAO.updateStrategyDefinition(stratDef);
		}
	}
}
