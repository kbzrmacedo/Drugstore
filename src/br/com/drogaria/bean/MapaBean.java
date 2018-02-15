package br.com.drogaria.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean (name = "MBMapa")
public class MapaBean implements Serializable {
    
    private MapModel simpleModel;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(-23.568062, -46.647691099999975);
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}