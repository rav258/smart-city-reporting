CREATE TABLE categories
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    active      BIT          NOT NULL DEFAULT 1,
    created_at  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT uk_categories_name UNIQUE (name)
);

CREATE TABLE districts
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    code       VARCHAR(50),
    active     BIT          NOT NULL DEFAULT 1,
    created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT uk_districts_name UNIQUE (name),
    CONSTRAINT uk_districts_code UNIQUE (code)
);

-- Sample categories
INSERT INTO categories (name, description, active)
SELECT 'POTHOLE', 'Road surface damage such as potholes', 1
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'POTHOLE');

INSERT INTO categories (name, description, active)
SELECT 'BROKEN_STREET_LIGHT', 'Street light not working or damaged', 1
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'BROKEN_STREET_LIGHT');

INSERT INTO categories (name, description, active)
SELECT 'GRAFFITI', 'Graffiti on public property', 1
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'GRAFFITI');

INSERT INTO categories (name, description, active)
SELECT 'RUBBISH', 'Illegal dumping or excessive rubbish', 1
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'RUBBISH');

INSERT INTO categories (name, description, active)
SELECT 'DAMAGED_ROAD_SIGN', 'Missing or damaged road sign', 1
WHERE NOT EXISTS (SELECT 1 FROM categories WHERE name = 'DAMAGED_ROAD_SIGN');

-- Sample districts
INSERT INTO districts (name, code, active)
SELECT 'Central', 'CENTRAL', 1
WHERE NOT EXISTS (SELECT 1 FROM districts WHERE name = 'Central');

INSERT INTO districts (name, code, active)
SELECT 'North', 'NORTH', 1
WHERE NOT EXISTS (SELECT 1 FROM districts WHERE name = 'North');

INSERT INTO districts (name, code, active)
SELECT 'South', 'SOUTH', 1
WHERE NOT EXISTS (SELECT 1 FROM districts WHERE name = 'South');

INSERT INTO districts (name, code, active)
SELECT 'East', 'EAST', 1
WHERE NOT EXISTS (SELECT 1 FROM districts WHERE name = 'East');

INSERT INTO districts (name, code, active)
SELECT 'West', 'WEST', 1
WHERE NOT EXISTS (SELECT 1 FROM districts WHERE name = 'West');