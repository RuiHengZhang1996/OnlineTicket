import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Ticket } from 'src/app/common/ticket';
import { CartService } from 'src/app/services/cart.service';
import { TicketService } from 'src/app/services/ticket.service';
@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.css']
})
export class TicketDetailsComponent implements OnInit {
  ticket: Ticket = new Ticket();
  constructor(private ticketService: TicketService, 
              private cartService: CartService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleTicketDetails();
    })
  }
  handleTicketDetails() { 
    //get the id param to a string  convert string to a number with +


    const theTicketId: number = +this.route.snapshot.paramMap.get('id')!;

    this.ticketService.getTicket(theTicketId).subscribe(
      data => {
        this.ticket = data;
      }
    )
  }

  addToCart() {
    console.log(`Adding to Cart: ${this.ticket.name}, ${this.ticket.unitPrice}`)
    const theCartItem = new CartItem(this.ticket);
    this.cartService.addToCart(theCartItem);
  }

}
