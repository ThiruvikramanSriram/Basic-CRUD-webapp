import { NgModule } from '@angular/core';
import { ServerModule } from '@angular/platform-server';
import { provideServerRoutesConfig } from '@angular/ssr';
import { AppComponent } from './app.component';
import { AppModule } from './app.module';
import { serverRoutes } from './app.routes.server';
import {  provideHttpClient } from '@angular/common/http';

@NgModule({
  imports: [AppModule, ServerModule],
  providers: [provideHttpClient(), provideServerRoutesConfig(serverRoutes)],
  bootstrap: [AppComponent],
})
export class AppServerModule {}
