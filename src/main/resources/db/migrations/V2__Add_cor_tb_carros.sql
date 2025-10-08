--V2: Migrations para adicionar a coluna de cores na tabella dos carros

ALTER TABLE TB_CARROS
ADD COLUMN COR VARCHAR(50);
