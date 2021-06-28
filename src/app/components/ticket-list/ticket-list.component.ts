import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Ticket } from 'src/app/common/ticket';
import { CartService } from 'src/app/services/cart.service';
import { TicketService } from 'src/app/services/ticket.service';

@Component({
  selector: 'app-ticket-list',
  //templateUrl: './ticket-list.component.html',
  //templateUrl: './ticket-list-table.component.html',
  templateUrl: './ticket-list-grid.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {
  
  tickets: Ticket[] = [];
  currentCategoryId: number = 1;
  previousCategoryId: number = 1;
;
  searchMode: boolean = false;

  thePageNumber: number = 1;
  thePageSize: number = 5;
  theTotalElements: number = 0;

  constructor(private ticketService: TicketService, 
              private cartService: CartService,
              private route: ActivatedRoute) {
    
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listTickets();
    }) 
    
  }

  listTickets() {
    this.searchMode = this.route.snapshot.paramMap.has('keyword')
    
    if(this.searchMode) {
      this.handleSearchTickets();
    } else {
      this.handleListTickets();
    }
    
  }

  handleSearchTickets() {
    const theKeyword: string = this.route.snapshot.paramMap.get('keyword')!;
    this.ticketService.searchTickets(theKeyword).subscribe(
      data=> {
        this.tickets = data;
      }
    )
  }
  handleListTickets() {
    //check id available?
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    if(hasCategoryId) {
      //get id string, convert string to a number using the "+" symbol
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id')!;
    } else {
      this.currentCategoryId = 1;
    }

    //check if having a diff category id with previous
    if(this.previousCategoryId != this.currentCategoryId) {
      this.thePageNumber = 1;
    }

    this.previousCategoryId = this.currentCategoryId;
    console.log(`currentCategoryId=${this.currentCategoryId}, thePageNumber=${this.thePageNumber}`);

    this.ticketService.getTicketListPaginate(this.thePageNumber - 1,
                                            this.thePageSize,
                                            this.currentCategoryId)
                                            .subscribe(this.processResult());
  }
  processResult() {
    return (data: any) => {
      this.tickets = data._embedded.tickets;
      this.thePageNumber = data.page.number + 1;
      this.thePageSize = data.page.size;
      this.theTotalElements = data.page.totalElements;
    }
  }

  updatePageSize(PageSize: number) {
    this.thePageSize = PageSize;
    this.thePageNumber = 1;
    this.listTickets();
  }

  addtoCart(theTicket: Ticket) {
    console.log(`Adding to cart: ${theTicket.name}, ${theTicket.unitPrice}`);
    //test
    const theCartItem = new CartItem(theTicket);
    this.cartService.addToCart(theCartItem);
  }
}
