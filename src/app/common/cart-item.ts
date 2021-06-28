import { tick } from "@angular/core/testing";
import { Ticket } from "./ticket";

export class CartItem {
    id!: string;
    name!: string;
    imageUrl!: string;
    unitPrice!: number;

    quantity!: number;

    constructor(ticket: Ticket) {
        this.id = ticket.id;
        this.name = ticket.name;
        this.imageUrl = ticket.imageUrl;
        this.unitPrice = ticket.unitPrice;
        this.quantity = 1;
    }
}
