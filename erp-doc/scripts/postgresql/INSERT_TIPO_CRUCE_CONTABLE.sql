INSERT INTO gluo_tipo_cruce_contable (ticc_id,
                                      descripcion,
                                      activo,
                                      fecha_creacion,
                                      fecha_modificacion,
                                      usu_creador,
                                      usu_modificador)
        VALUES (
                  1,
                  'RENTAS                                                                                                                                                                                                  ',
                  'A',
                  TO_TIMESTAMP ('09/25/2015 17:07:28.00',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  1,
                  NULL);

INSERT INTO gluo_tipo_cruce_contable (ticc_id,
                                      descripcion,
                                      activo,
                                      fecha_creacion,
                                      fecha_modificacion,
                                      usu_creador,
                                      usu_modificador)
        VALUES (
                  2,
                  'GASTOS                                                                                                                                                                                                  ',
                  'A',
                  TO_TIMESTAMP ('09/25/2015 17:07:44.00',
                                'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
                  NULL,
                  1,
                  NULL);

COMMIT;