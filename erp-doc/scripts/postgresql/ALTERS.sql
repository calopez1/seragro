
--Se adiciona el valor disponible en la tabla detalle crp
alter table gluo_detalle_crp
  add valor_disponible Numeric(16,2)  not null;

--Se elimina la relacion entre cuenta contable y op  
alter table gluo_op drop column ccon_id_gasto;

ALTER TABLE GLUO_ARQUEO_CAJA ADD COLUMN ESTADO CHARACTER (1) NOT NULL;

alter table gluo_consignacion add column consecutivo text;
alter table gluo_ingreso_no_propio add column consecutivo text;
alter table gluo_nota_contabilidad add column consecutivo text;
alter table gluo_cartera add column consecutivo text;
alter table gluo_detalle_liquidacion_masiva_impuestos add column consecutivo text;



-- Se adiciona el año fiscal apra los peridos de nomina
ALTER TABLE gluo_liquidacion_nomina ADD COLUMN anof_id Integer;
ALTER TABLE gluo_liquidacion_nomina ADD CONSTRAINT fk_lino_anof FOREIGN KEY (anof_id)  REFERENCES gluo_ano_fiscal  ON DELETE CASCADE;