CREATE TABLE users.users (
                             user_id uuid PRIMARY KEY,
                             first_name VARCHAR(100) NOT NULL,
                             last_name VARCHAR(100) NOT NULL,
                             image_url TEXT,
                             email VARCHAR(255) UNIQUE NOT NULL,
                             phone VARCHAR(20),
                             created_at TIMESTAMP DEFAULT NOW(),
                             updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE users.credentials (
                                   credential_id uuid PRIMARY KEY,
                                   user_id uuid NOT NULL REFERENCES users.users(user_id) ON DELETE CASCADE,
                                   username VARCHAR(100) UNIQUE NOT NULL,
                                   password TEXT NOT NULL,
                                   role VARCHAR(50),
                                   is_enabled BOOLEAN DEFAULT TRUE,
                                   is_account_non_expired BOOLEAN DEFAULT TRUE,
                                   is_account_non_locked BOOLEAN DEFAULT TRUE,
                                   is_credentials_non_expired BOOLEAN DEFAULT TRUE,
                                   created_at TIMESTAMP DEFAULT NOW(),
                                   updated_at TIMESTAMP DEFAULT NOW()
);
