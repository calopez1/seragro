--Lo que no se borra y se debe cargar:
--Terceros

DELETE FROM gluo_cruce_contable;

DELETE FROM gluo_detalle_ingreso_no_propio;

DELETE FROM gluo_dpto_x_cgr;

DELETE FROM gluo_detalle_consignacion;

DELETE FROM gluo_arqueo_x_forma_pago;

DELETE FROM gluo_arqueo_x_concepto_renta;

DELETE FROM gluo_recibo_forma_pago;

DELETE FROM gluo_parametrizacion_concepto;

DELETE FROM gluo_arqueo_x_aforo;

DELETE FROM gluo_deduccion_aplicada;

DELETE FROM gluo_deduccion_x_concepto_pago;

DELETE FROM gluo_deduccion;

DELETE FROM gluo_detalle_modificacion_rubro_ppto;

DELETE FROM gluo_detalle_ce_afecta_ppto;

DELETE FROM gluo_op;

DELETE FROM gluo_detalle_crp;

DELETE FROM gluo_detalle_rcdp;

DELETE FROM gluo_rcdp;

DELETE FROM gluo_detalle_cdp;

DELETE FROM gluo_detalle_traslado;

DELETE FROM gluo_dpto_x_tipo_concepto_nomina;

DELETE FROM gluo_detalle_cdp_anulado;

delete from gluo_aplicacion_pago_mes;

delete from gluo_aplicacion_pago;

delete from gluo_cartera;

delete from gluo_prioridad_concepto;

DELETE FROM gluo_interes_mora_impuesto;

delete from gluo_liquidacion_otros_conceptos_impuesto;

delete from gluo_detalle_liquidacion_masiva_impuestos;

delete from gluo_descuento_impuesto;

DELETE FROM GLUO_CONCEPTO_IMPUESTO;

DELETE FROM gluo_detalle_presupuesto;

DELETE FROM gluo_traslado;

DELETE FROM gluo_presupuesto;

DELETE FROM gluo_recibo;

DELETE FROM gluo_adjunto_documento_presupuesto;

DELETE FROM gluo_crp;

DELETE FROM gluo_cdp;

DELETE FROM gluo_ce_x_op;

DELETE FROM gluo_maestro_op;

DELETE FROM gluo_maestro_ce_afecta_ppto;

DELETE FROM gluo_cuco_x_enap;

DELETE FROM gluo_ce_no_afecta_ppto;

DELETE FROM gluo_saldo_cuenta_contable
      WHERE moco_id <> -1;

DELETE FROM gluo_movimiento_contable
      WHERE moco_id <> -1;


DELETE FROM gluo_propietario;

DELETE FROM gluo_predio_ano_fiscal;

delete from gluo_excepcion_predio;

DELETE FROM gluo_predio;

DELETE FROM gluo_numero_predio;

DELETE FROM gluo_cdp_anulado;

DELETE FROM gluo_solicitud_cdp;

DELETE FROM gluo_cargo_empleado_grado;

DELETE FROM gluo_modificacion_rubro_ppto;

DELETE FROM gluo_soporte_acto_administrativo;

DELETE FROM gluo_acto_administrativo;

DELETE FROM gluo_consignacion;

DELETE FROM gluo_arqueo_caja;

DELETE FROM gluo_detalle_crp_anulado;

DELETE FROM gluo_crp_anulado;

DELETE FROM gluo_contrato_crp;

DELETE FROM gluo_detalle_ce_afecta_ppto_anulado;

DELETE FROM gluo_maestro_ce_afecta_ppto_anulado;

DELETE FROM gluo_op_anulado;

DELETE FROM gluo_maestro_op_anulado;

DELETE FROM gluo_concepto_pago;

DELETE FROM gluo_detalle_comprobante_traslado_bancario;

DELETE FROM gluo_comprobante_traslado_bancario;

DELETE FROM gluo_cuco_x_enap_anulado;

DELETE FROM gluo_ce_no_afecta_ppto_anulado;

DELETE FROM gluo_ingreso_no_propio;

DELETE FROM gluo_saldo_cuenta_contable;

DELETE FROM gluo_movimiento_contable;

DELETE FROM gluo_porcentaje_rango_avaluo;

delete from gluo_liquidacion_masiva_impuestos;

DELETE FROM gluo_ano_fiscal;

DELETE FROM gluo_acto_administrativo;

DELETE FROM gluo_archivo_soporte;

DELETE FROM gluo_parametro_informe;

DELETE FROM gluo_parametro
      WHERE EMPR_ID IS NOT NULL;

INSERT INTO gluo_empresa (empr_id,
                          identificacion,
                          razon_social,
                          descripcion_1,
                          descripcion_2,
                          activo,
                          fecha_creacion,
                          usu_creador,
                          tiid_id,
                          cuenta_caja,
                          eslo_id,
                          tiem_id,
                          codigo,
                          muni_id)
     VALUES (:pEmprId,
             ':pIdentificacionEmpresa',
             ':pNombreEmpresa',
             ':pNombreEmpresa',
             ':pNombreEmpresa',
             'A',
             CURRENT_TIMESTAMP,
             1,
             1,
             NULL,
             1,
             1,
             :pIdentificacionEmpresa,
             :pMuniId);


UPDATE gluo_cuenta_contable
   SET empr_id = :pEmprId
 WHERE empr_id = :pEmpresaIdABorrar;

DELETE FROM gluo_centro_costos;

UPDATE gluo_concepto_nomina
   SET empr_id = :pEmprId
 WHERE empr_id = :pEmpresaIdABorrar;

UPDATE gluo_grado_salarial
   SET empr_id = :pEmprId
 WHERE empr_id = :pEmpresaIdABorrar;

DELETE FROM gluo_parametro_informe
      WHERE empr_id = :pEmpresaIdABorrar;

DELETE FROM gluo_detalle_liquidacion_nomina;

DELETE FROM gluo_liquidacion_nomina_empleado;

DELETE FROM gluo_liquidacion_nomina;

DELETE FROM gluo_parametro
      WHERE empr_id = :pEmpresaIdABorrar;

DELETE FROM gluo_fecha_situacion_adm;

DELETE FROM gluo_siad_x_empl;

update gluo_situacion_administrativa set empr_id = :pEmprId where empr_id = :pEmpresaIdABorrar;

update gluo_situacion_administrativa set siad_id = siad_id + :pEmprId - 1;

--OJO. los terceros no se borran. Por cuestion de pruebas

UPDATE gluo_tercero
   SET empr_id = :pEmprId
 WHERE empr_id = :pEmpresaIdABorrar;


DELETE FROM gluo_cheque_usado;

DELETE FROM gluo_chequera;

DELETE FROM gluo_cuenta_bancaria;

UPDATE GLUO_CUENTA_CONTABLE
   SET empr_id = :pEmprId
 WHERE empr_id = :pEmpresaIdABorrar;

DELETE FROM gluo_empresa
      WHERE empr_id = :pEmpresaIdABorrar;

ALTER TABLE GLUO_CUENTA_CONTABLE DROP CONSTRAINT FK_CCON_CCON;

ALTER TABLE GLUO_CONF_CC_X_NAT DROP CONSTRAINT fk_ccon_ccxn;

UPDATE GLUO_CUENTA_CONTABLE
   SET ccon_id = ccon_id + :pCconIdValorASumar;


UPDATE GLUO_CUENTA_CONTABLE
   SET fk_ccon_id = fk_ccon_id + :pCconIdValorASumar
 WHERE fk_ccon_id IS NOT NULL;

 
UPDATE gluo_conf_cc_x_nat SET ccon_id = ccon_id + :pCconIdValorASumar;
 
ALTER TABLE gluo_conf_cc_x_nat
   ADD CONSTRAINT fk_ccon_ccxn FOREIGN KEY (ccon_id)
       REFERENCES gluo_cuenta_contable (ccon_id);

ALTER TABLE GLUO_CUENTA_CONTABLE
   ADD CONSTRAINT FK_CCON_CCON FOREIGN KEY
          (FK_CCON_ID)
          REFERENCES GLUO_CUENTA_CONTABLE (CCON_ID)
             ON DELETE NO ACTION
             ON UPDATE NO ACTION;



INSERT INTO gluo_parametro (para_id,
                            descripcion,
                            valor,
                            usu_creador,
                            usu_modificador,
                            fecha_creacion,
                            fecha_modificacion,
                            activo,
                            empr_id,
                            codigo)
        VALUES (
                  :pEmprId + 0,
                  'Tipo de contabilización (1=Causación, 2=Caja)',
                  '2',
                  1,
                  NULL,
                  TO_TIMESTAMP ('03/15/2016 16:21:34.00',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A',
                  :pEmprId,
                  'TIC');

INSERT INTO gluo_parametro (para_id,
                            descripcion,
                            valor,
                            usu_creador,
                            usu_modificador,
                            fecha_creacion,
                            fecha_modificacion,
                            activo,
                            empr_id,
                            codigo)
        VALUES (
                  :pEmprId + 1,
                  'Muestra arbol presupuestal en CDP (S, N)',
                  'S',
                  1,
                  NULL,
                  TO_TIMESTAMP ('03/15/2016 16:21:34.00',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A',
                  :pEmprId,
                  'SHT');

INSERT INTO gluo_parametro (para_id,
                            descripcion,
                            valor,
                            usu_creador,
                            usu_modificador,
                            fecha_creacion,
                            fecha_modificacion,
                            activo,
                            empr_id,
                            codigo)
        VALUES (
                  :pEmprId + 2,
                  'Codigo Entidad',
                  ':pCodEnt',
                  1,
                  NULL,
                  TO_TIMESTAMP ('03/15/2016 16:21:34.00',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A',
                  :pEmprId,
                  'COD_ENT');

INSERT INTO gluo_parametro (para_id,
                            descripcion,
                            valor,
                            usu_creador,
                            usu_modificador,
                            fecha_creacion,
                            fecha_modificacion,
                            activo,
                            empr_id,
                            codigo)
        VALUES (
                  :pEmprId + 3,
                  'Situcion Administrativa Incapacidad',
                  'XYZ',
                  1,
                  NULL,
                  TO_TIMESTAMP ('11/28/2016 16:16:37.813',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A',
                  :pEmprId,
                  'INC');

INSERT INTO gluo_parametro (para_id,
                            descripcion,
                            valor,
                            usu_creador,
                            usu_modificador,
                            fecha_creacion,
                            fecha_modificacion,
                            activo,
                            empr_id,
                            codigo)
        VALUES (
                  :pEmprId + 4,
                  'Cantidad Salarios Minimos',
                  '2',
                  1,
                  NULL,
                  TO_TIMESTAMP ('11/28/2016 16:17:18.971',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A',
                  :pEmprId,
                  'CSM');



INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 0,
                  :pEmprId,
                  'CABE_LINEA_1',
                  ':pCabeLinea1',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:30.08',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 1,
                  :pEmprId,
                  'CABE_LINEA_2',
                  ':pCabeLinea2',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:30.287',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 2,
                  :pEmprId,
                  'CABE_LINEA_3',
                  ':pCabeLinea3',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:30.492',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 3,
                  :pEmprId,
                  'CABE_LINEA_4',
                  ':pCabeLinea4',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:30.682',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 4,
                  :pEmprId,
                  'CABE_LINEA_5',
                  ':pCabeLinea5',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:30.880',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 5,
                  :pEmprId,
                  'CABE_LINEA_6',
                  ':pCabeLinea6',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:31.66',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 6,
                  :pEmprId,
                  'PIE_LINEA_1',
                  ':pPieLinea1',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:31.470',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 7,
                  :pEmprId,
                  'PIE_LINEA_2',
                  ':pPieLinea2',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:31.673',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 8,
                  :pEmprId,
                  'PIE_LINEA_3',
                  ':pPieLinea3',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:31.876',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 9,
                  :pEmprId,
                  'CARGO_PRES',
                  ':pCargoPres',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:32.67',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 10,
                  :pEmprId,
                  'CARGO_ALCA',
                  ':pCargoAlca',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:32.264',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 11,
                  :pEmprId,
                  'CARGO_BENE',
                  ':pCargoBene',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:32.423',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 12,
                  :pEmprId,
                  'CARGO_AUAD',
                  ':pCargoAuad',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:32.615',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 13,
                  :pEmprId,
                  'CARGO_CONT',
                  ':pCargoCont',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:32.815',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 14,
                  :pEmprId,
                  'CARGO_SEHA',
                  ':pCargoSeha',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('07/26/2016 17:50:33.21',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 15,
                  :pEmprId,
                  'NOMBRE_CARGO_SEHA',
                  ':pNombreCargoSeha',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('12/13/2016 08:01:47.14',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 16,
                  :pEmprId,
                  'NOMBRE_CARGO_AUAD',
                  ':pNombreCargoAuad',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('12/13/2016 08:02:03.345',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 17,
                  :pEmprId,
                  'NOMBRE_CARGO_ALCA',
                  ':pNombreCargoAlca',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('12/13/2016 08:02:05.934',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 18,
                  :pEmprId,
                  'NOMBRE_CARGO_PRES',
                  ':pNombreCargoPres',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('12/13/2016 08:02:08.365',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');

INSERT INTO gluo_parametro_informe (pain_id,
                                    empr_id,
                                    codigo,
                                    valor,
                                    descripcion,
                                    usu_creador,
                                    usu_modificador,
                                    fecha_creacion,
                                    fecha_modificacion,
                                    activo)
        VALUES (
                  :pEmprId + 19,
                  :pEmprId,
                  'NOMBRE_CARGO_PRES_1',
                  ':pNombreCargoPres1',
                  NULL,
                  1,
                  NULL,
                  TO_TIMESTAMP ('12/13/2016 08:02:16.470',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  'A');



INSERT INTO gluo_ano_fiscal (anof_id,
                             ano_fiscal,
                             descripcion,
                             fecha_incio_ano_fiscal,
                             estado,
                             activo,
                             fecha_creacion,
                             usu_creador,
                             valor_salario_minimo,
                             empr_id)
     VALUES (101,
             2012,
             '2012',
             TO_DATE ('01/01/2012', 'dd/MM/yyyy'),
             'C',
             'A',
             current_timestamp,
             1,
             0,
             :pEmprId);

INSERT INTO gluo_ano_fiscal (anof_id,
                             ano_fiscal,
                             descripcion,
                             fecha_incio_ano_fiscal,
                             estado,
                             activo,
                             fecha_creacion,
                             usu_creador,
                             valor_salario_minimo,
                             empr_id)
     VALUES (102,
             2013,
             '2013',
             TO_DATE ('01/01/2013', 'dd/MM/yyyy'),
             'C',
             'A',
             current_timestamp,
             1,
             0,
             :pEmprId);

INSERT INTO gluo_ano_fiscal (anof_id,
                             ano_fiscal,
                             descripcion,
                             fecha_incio_ano_fiscal,
                             estado,
                             activo,
                             fecha_creacion,
                             usu_creador,
                             valor_salario_minimo,
                             empr_id)
     VALUES (103,
             2014,
             '2014',
             TO_DATE ('01/01/2014', 'dd/MM/yyyy'),
             'C',
             'A',
             current_timestamp,
             1,
             0,
             :pEmprId);

INSERT INTO gluo_ano_fiscal (anof_id,
                             ano_fiscal,
                             descripcion,
                             fecha_incio_ano_fiscal,
                             estado,
                             activo,
                             fecha_creacion,
                             usu_creador,
                             valor_salario_minimo,
                             empr_id)
     VALUES (104,
             2015,
             '2015',
             TO_DATE ('01/01/2015', 'dd/MM/yyyy'),
             'C',
             'A',
             current_timestamp,
             1,
             0,
             :pEmprId);

INSERT INTO gluo_ano_fiscal (anof_id,
                             ano_fiscal,
                             descripcion,
                             fecha_incio_ano_fiscal,
                             estado,
                             activo,
                             fecha_creacion,
                             usu_creador,
                             valor_salario_minimo,
                             empr_id)
     VALUES (105,
             2016,
             '2016',
             TO_DATE ('01/01/2016', 'dd/MM/yyyy'),
             'A',
             'A',
             current_timestamp,
             1,
             0,
             :pEmprId);