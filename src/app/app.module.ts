import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TicketListComponent } from './components/ticket-list/ticket-list.component';
import { HttpClientModule } from '@angular/common/http';
import { TicketService } from './services/ticket.service';
import { Routes, RouterModule } from '@angular/router';
import { TicketCategoryMenuComponent } from './components/ticket-category-menu/ticket-category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { TicketDetailsComponent } from './components/ticket-details/ticket-details.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';


const routes: Routes = [
  {path: 'cart-details', component: CartDetailsComponent},
  {path: 'tickets/:id', component: TicketDetailsComponent},
  {path: 'search/:keyword', component: TicketListComponent},
  {path: 'category/:id', component: TicketListComponent},
  {path: 'category', component: TicketListComponent},
  {path: 'tickets', component: TicketListComponent},
  {path: '', redirectTo: '/tickets', pathMatch: 'full'},
  {path: '**', redirectTo: '/tickets', pathMatch: 'full'}
];
@NgModule({
  declarations: [    
    AppComponent,
    TicketListComponent,
    TicketCategoryMenuComponent,
    SearchComponent,
    TicketDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [TicketService],
  bootstrap: [AppComponent]
})
export class AppModule { }
