import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientAddComponent } from './client-add.component';

describe('AddClientComponent', () => {
  let component: ClientAddComponent;
  let fixture: ComponentFixture<ClientAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ClientAddComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
