package com.fiftycuatro.jetty.rest.v1;

import com.fiftycuatro.jetty.api.EntryPoint;
import com.fiftycuatro.jetty.api.SampleDTO;

public class EntryPointImpl implements EntryPoint {

   @Override
   public SampleDTO test() {
      SampleDTO dto = new SampleDTO();
      dto.setName("Phil");
      dto.setAge(23);
      return dto; 
   }
}
