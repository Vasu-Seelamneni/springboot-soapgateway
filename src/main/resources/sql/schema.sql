/*CREATE TABLE account (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         account_number VARCHAR(50),
                         account_holder_name VARCHAR(100),
                         balance DECIMAL(19, 2),
                         type VARCHAR(20)
);


CREATE TABLE transaction (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             account_id BIGINT NOT NULL,
                             amount DECIMAL(19, 2),
                             type VARCHAR(20),
                             transaction_date TIMESTAMP,
                             description VARCHAR(255),
                             FOREIGN KEY (account_id) REFERENCES account(id)
);
*/