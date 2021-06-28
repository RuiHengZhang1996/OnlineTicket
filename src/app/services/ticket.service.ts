import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from '../common/ticket';
import { map } from 'rxjs/operators';
import { TicketCategory } from '../common/ticket-category';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private baseUrl = 'http://localhost:8080/api/tickets';
  private categoryUrl = 'http://localhost:8080/api/ticket-category'
  constructor(private httpClient: HttpClient) { }

  getTicketList(theCategoryId: number): Observable<Ticket[]> {

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;
    return this.getTickets(searchUrl);
  }
  getTicketListPaginate (thePage: number, 
                          thePageSize: number, 
                          theCategoryId: number): Observable<GetResponseTickets> {

    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}` 
                    + `&page=${thePage}&size=${thePageSize}`;
    return this.httpClient.get<GetResponseTickets>(searchUrl);
  }
  getTicketCategories(): Observable<TicketCategory[]> {
    return this.httpClient.get<GetResponseTicketsCategory>(this.categoryUrl).pipe(
      map(respose => respose._embedded.ticketCategory)
    );
  }

  searchTickets(theKeyword: string): Observable<Ticket[]> {
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}`;
    return this.getTickets(searchUrl);
  }

  private getTickets(searchUrl: string): Observable<Ticket[]> {
    return this.httpClient.get<GetResponseTickets>(searchUrl).pipe(
      map(respose => respose._embedded.tickets)
    );
  }

  getTicket(theTicketId: number): Observable<Ticket>{
    const ticketUrl = `${this.baseUrl}/${theTicketId}`;
    return this.httpClient.get<Ticket>(ticketUrl);
  }
}

interface GetResponseTickets {
  _embedded: {
    tickets: Ticket[];
  }
  page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number: number
  }
}

interface GetResponseTicketsCategory {
  _embedded: {
    ticketCategory: TicketCategory[];
  }
}
