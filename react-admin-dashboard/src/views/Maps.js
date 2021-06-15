import React, {useState} from 'react';
import ReactMapGL from 'react-map-gl';



export default function Maps() {
  let [viewport, setViewport] = useState({
    latitude: 39.3999,
    longitude: -8.224454,
    width: window.innerWidth,
    height: window.innerHeight,
    zoom: 10
  });





  return (

      <div>
        <ReactMapGL
        {...viewport}
        mapboxApiAccessToken={
        "pk.eyJ1IjoicnViZW5tZW5pbm8iLCJhIjoiY2tweTB0Y2xvMDgzYjJvbzYyYWowMDZ1ciJ9.ytkMCweXVZCHVkBgbsfxHQ"
      }
        onViewportChange={(newView) => setViewport(newView)}
        >
          
           markers here
        </ReactMapGL>
      </div>

  );
}
