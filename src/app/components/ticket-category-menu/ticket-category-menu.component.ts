import { i18nMetaToJSDoc } from '@angular/compiler/src/render3/view/i18n/meta';
import { Component, OnInit } from '@angular/core';
import { TicketCategory } from 'src/app/common/ticket-category';
import { TicketService } from 'src/app/services/ticket.service';
@Component({
  selector: 'app-ticket-category-menu',
  templateUrl: './ticket-category-menu.component.html',
  styleUrls: ['./ticket-category-menu.component.css']
})
export class TicketCategoryMenuComponent implements OnInit {

  ticketCategories!: TicketCategory[];

  constructor(private ticketService: TicketService) { }

  ngOnInit(): void {
    this.listTicketCategories();
  }

  listTicketCategories() {
    this.ticketService.getTicketCategories().subscribe(
      data=>{
        console.log('Ticket Categories=' + JSON.stringify(data));
        this.ticketCategories = data;
      }
    );
  }

}
