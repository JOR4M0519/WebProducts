-- Name DB: tienda

CREATE TABLE Producto (
                          cArt VARCHAR(50),
                          seccion VARCHAR(50) NOT NULL,
                          nArt VARCHAR(100) NOT NULL,
                          precio DOUBLE NOT NULL,
                          fecha DATE NOT NULL,
                          importado VARCHAR(10) NOT NULL,
                          paisOrig VARCHAR(50) NOT NULL,
                          PRIMARY KEY (cArt)
);


INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P001', 'Electrónica', 'Smartphone', 599.99, '2024-02-07', 'Sí', 'China');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P002', 'Ropa', 'Camiseta', 29.99, '2024-02-07', 'No', 'España');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P003', 'Electrodomésticos', 'Refrigerador', 799.99, '2024-02-07', 'Sí', 'Estados Unidos');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P004', 'Juguetes', 'Muñeca', 19.99, '2024-02-07', 'No', 'México');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P005', 'Libros', 'Novela', 12.99, '2024-02-07', 'No', 'Argentina');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P006', 'Electrónica', 'Auriculares', 79.99, '2024-02-07', 'Sí', 'Corea del Sur');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P007', 'Hogar', 'Lámpara', 49.99, '2024-02-07', 'No', 'Italia');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P008', 'Deportes', 'Balón de fútbol', 24.99, '2024-02-07', 'No', 'Brasil');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P009', 'Electrodomésticos', 'Licuadora', 39.99, '2024-02-07', 'Sí', 'México');

INSERT INTO Producto (cArt, seccion, nArt, precio, fecha, importado, paisOrig)
VALUES ('P010', 'Ropa', 'Pantalón', 49.99, '2024-02-07', 'No', 'China');
