CREATE TABLE booking
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     date     NOT NULL,
    updated_at     datetime NOT NULL,
    review_id      BIGINT NULL,
    status       ENUM('SCHEDULED',
        'CANCELLED',
        'CAR_ARRIVED',
        'ASSIGNED_DRIVER',
        'IN_RIDE')   NULL,
    start_time     date NULL,
    end_time       datetime NULL,
    total_distance BIGINT NULL,
    driver_id      BIGINT NULL,
    passenger_id   BIGINT NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE booking_review
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at date         NOT NULL,
    updated_at datetime     NOT NULL,
    content    VARCHAR(255) NOT NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_booking_review PRIMARY KEY (id)
);

CREATE TABLE driver
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     date         NOT NULL,
    updated_at     datetime     NOT NULL,
    name           VARCHAR(255) NULL,
    license_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE passenger
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at date     NOT NULL,
    updated_at datetime NOT NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE passesnger_review
(
    id                       BIGINT       NOT NULL,
    passenger_review_content VARCHAR(255) NOT NULL,
    passenger_rating         VARCHAR(255) NOT NULL,
    CONSTRAINT pk_passesngerreview PRIMARY KEY (id)
);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_REVIEW FOREIGN KEY (review_id) REFERENCES booking_review (id);

ALTER TABLE passesnger_review
    ADD CONSTRAINT FK_PASSESNGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES booking_review (id);