import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { PageAComponent } from "./app.page-a";
import { PageBComponent } from "./app.page-b";
import { PageDefault } from "./app.pagedefault";

const appRoutes: Routes = [
    {path: 'page-a', component: PageAComponent},
    {path: 'page-b/:id/:firstname', component: PageBComponent},
    {path: '', redirectTo: '/page-a', pathMatch: 'full'},
    {path: '**', component: PageDefault}
];

export const routing: ModuleWithProviders<any> = RouterModule.forRoot(appRoutes);