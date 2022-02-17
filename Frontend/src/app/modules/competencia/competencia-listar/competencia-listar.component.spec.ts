import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetenciaListarComponent } from './competencia-listar.component';

describe('CompetenciaListarComponent', () => {
  let component: CompetenciaListarComponent;
  let fixture: ComponentFixture<CompetenciaListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompetenciaListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompetenciaListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
