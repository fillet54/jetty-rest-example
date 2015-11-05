package com.fiftycuatro.jetty.rest.v1;

import com.fiftycuatro.jetty.api.EntryPoint;

public class EntryPointImpl implements EntryPoint {

   @Override
   public String test() {
      return "TESTING 123!";
   }
}
