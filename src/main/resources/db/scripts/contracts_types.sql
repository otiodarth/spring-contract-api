CREATE TABLE contracts_types (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     description VARCHAR(100) NOT NULL UNIQUE,
     created_at TIMESTAMP NOT NULL DEFAULT NOW(),
     updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);