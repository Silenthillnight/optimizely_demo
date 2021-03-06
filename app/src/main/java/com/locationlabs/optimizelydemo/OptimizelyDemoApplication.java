package com.locationlabs.optimizelydemo;

import android.app.Application;
import android.content.Context;

import com.locationlabs.optimizelydemo.injection.component.AppComponent;
import com.locationlabs.optimizelydemo.injection.component.DaggerAppComponent;
import com.locationlabs.optimizelydemo.injection.module.AppModule;

public class OptimizelyDemoApplication extends Application {

   private static OptimizelyDemoApplication app;

   private AppComponent appComponent;

   public static OptimizelyDemoApplication get(Context context) {
      return (OptimizelyDemoApplication) context.getApplicationContext();
   }

   @Override
   public void onCreate() {
      super.onCreate();
      app = this;
      buildDaggerDependencyGraph();
   }

   /**
    * Builds graph of global dependencies
    */
   private void buildDaggerDependencyGraph() {
      appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
   }

   public static OptimizelyDemoApplication get() {
      return app;
   }

   public AppComponent getAppComponent() {
      return appComponent;
   }
}
