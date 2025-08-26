CREATE TABLE IF NOT EXISTS messages
(
    msg_id    BIGINT PRIMARY KEY,
    timestamp BIGINT       NOT NULL,
    method    VARCHAR(10)  NOT NULL,
    uri       VARCHAR(500) NOT NULL
);