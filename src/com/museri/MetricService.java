package com.museri;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MetricService {
  
    public interface IMetric {
    
        String getName();
        double getValue();
    
    
  }
  
    
  public class Metric implements IMetric{
	  
	public Metric(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}

	private String name;
	private double value;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(double value) {
		this.value = value;
	}
    
  }
  
    /**
      Implements a Java equivalent to: 
      SELECT
          name,
          SUM(value) as value
       FROM metrics
       GROUP BY name;
    */
    public Collection<IMetric> groupMetricsJava8(Collection<IMetric> metrics) {
    	
        
    	EnumMap<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
    			  .collect(groupingBy(BlogPost::getType, 
    			  () -> new EnumMap<>(BlogPostType.class), toList()));
    	
    	
    	Map<String, Double> map = metrics.stream()
    			  .collect(Collectors.groupingBy(IMetric::getName, ()
    					  				-> new ArrayList<>(IMetric.class),Collectors.summingDouble(IMetric::getValue))
    					  				);
        
    	

    }
    
    
    
    public Collection<IMetric> groupMetrics(Collection<IMetric> metrics) {
    	
        
 	   LinkedHashMap<String, IMetric> map = new LinkedHashMap<String, IMetric>();
        for (Iterator<IMetric> iterator = metrics.iterator(); iterator.hasNext();) {
            IMetric iMetric = (IMetric) iterator.next();
            
            Metric current = (Metric)map.get(iMetric.getName());
            if (current==null){
                    map.put(iMetric.getName(), new Metric(iMetric.getName(),iMetric.getValue()));
            }else{
                    current.setValue(current.getValue() + iMetric.getValue());
            }
        }
        return map.values();
 }
    
    
}
