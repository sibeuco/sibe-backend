INSERT INTO tipo_identificacion (identificador, sigla, descripcion) VALUES
('b3c8f8e0-5e3e-4b7e-8b0e-8e5e8e5e8e5e', 'CC', 'Cédula de Ciudadanía'),
('a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d', 'TI', 'Tarjeta de Identidad'),
('f9e8d7c6-5b4a-3f2e-1d0c-9b8a7f6e5d4c', 'CE', 'Cédula de Extranjería')
ON CONFLICT (identificador) DO NOTHING;

INSERT INTO tipo_usuario (identificador, nombre, crear, modificar, eliminar, consultar) VALUES
('d1e2f3a4-b5c6-d7e8-f9a0-b1c2d3e4f5a6', 'Administrador', true, true, true, true),
('a0b9c8d7-e6f5-a4b3-c2d1-e0f9a8b7c6d5', 'Usuario', true, true, false, true)
ON CONFLICT (identificador) DO NOTHING;