import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TurmaFormacaoCrudComponent } from './turma-formacao-crud.component';

describe('TurmaFormacaoCrudComponent', () => {
  let component: TurmaFormacaoCrudComponent;
  let fixture: ComponentFixture<TurmaFormacaoCrudComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TurmaFormacaoCrudComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TurmaFormacaoCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
