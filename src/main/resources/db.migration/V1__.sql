CREATE TABLE category
(
    id               INT    NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    is_deleted       BIT(1) NOT NULL,
    title            VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

CREATE TABLE product
(
    id               INT    NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    is_deleted       BIT(1) NOT NULL,
    title            VARCHAR(255) NULL,
    `description`    VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id      INT NULL,
    image_url        VARCHAR(255) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);