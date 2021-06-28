import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketCategoryMenuComponent } from './ticket-category-menu.component';

describe('TicketCategoryMenuComponent', () => {
  let component: TicketCategoryMenuComponent;
  let fixture: ComponentFixture<TicketCategoryMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TicketCategoryMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketCategoryMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
