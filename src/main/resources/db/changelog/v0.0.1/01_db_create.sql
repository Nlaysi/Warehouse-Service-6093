CREATE TABLE IF NOT EXISTS catalog_item
(
    id uuid NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    price integer,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT catalog_item_pkey PRIMARY KEY (id)
    )
ENTER

CREATE TABLE IF NOT EXISTS warehouse_item
(
    id uuid NOT NULL,
    amount integer,
    booked integer,
    CONSTRAINT warehouse_item_pkey PRIMARY KEY (id),
    CONSTRAINT fkm3o54j7hnfjqbd2ldwopb0m06 FOREIGN KEY (id)
    REFERENCES public.catalog_item (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )
ENTER
