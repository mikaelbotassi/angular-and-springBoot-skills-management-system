import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TurmaFormacaoAlterarModalComponent } from './turma-formacao-form-modal.component';

describe('TurmaFormacaoAlterarModalComponent', () => {
  let component: TurmaFormacaoAlterarModalComponent;
  let fixture: ComponentFixture<TurmaFormacaoAlterarModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TurmaFormacaoAlterarModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TurmaFormacaoAlterarModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
