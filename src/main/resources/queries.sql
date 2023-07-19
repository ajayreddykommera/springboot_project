use submissions;
SET FOREIGN_KEY_CHECKS = 0;
CREATE TABLE leads
(
    id         BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    phone      VARCHAR(255)
);


CREATE TABLE consultants
(
    id         BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    phone      VARCHAR(255),
    lead_id    BIGINT,
    CONSTRAINT fk_lead_id FOREIGN KEY (lead_id)
        REFERENCES leads (id)
        ON DELETE CASCADE
);


CREATE TABLE submissions
(
    id                     BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    consultant_id          BIGINT,
    submission_date        DATE,
    technology             VARCHAR(255),
    vendor_company         VARCHAR(255),
    vendor_name            VARCHAR(255),
    vendor_email_address   VARCHAR(255),
    vendor_phone_number    VARCHAR(255),
    implementation_partner VARCHAR(255),
    client_name            VARCHAR(255),
    pay_rate               DECIMAL(10, 2),
    submission_status      VARCHAR(255),
    submission_type        VARCHAR(255),
    city                   VARCHAR(255),
    state                  VARCHAR(255),
    zip                    VARCHAR(10),
    CONSTRAINT fk_consultant_id FOREIGN KEY (consultant_id)
        REFERENCES consultants (id)
        ON DELETE CASCADE
);


CREATE TABLE submission_update
(
    id            BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    submission_id BIGINT,
    update_text   TEXT,
    created_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_submission_id FOREIGN KEY (submission_id)
        REFERENCES submissions (id)
        ON DELETE CASCADE
);

-- inserting values

INSERT INTO leads (first_name, last_name, email, phone)
VALUES ('vinay', 'kumar', 'vinay@gmail.com', 1234567890),
       ('praveen', 'kumar', 'praven@gmail.com', 1234567890),
       ('tejan', 'kumar', 'tejan@gmail.com', 1234567890);

INSERT INTO consultants (first_name, last_name, email, phone, lead_id)
VALUES ('Ajay', 'Kommera', 'ajay@gmail.com', 7639107427, 1),
       ('Tejaswini', 'Jalli', 'tejaswini@gmail.com', 9402901003, 1),
       ('Ravi', 'kannegundla', 'ravi@gmail.com', 9402901003, 3);


INSERT INTO submissions (consultant_id, submission_date, vendor_company, vendor_name, vendor_email_address,
                         vendor_phone_number, implementation_partner, client_name, pay_rate, submission_status,
                         submission_type, city, state, zip)
VALUES (1, '2023-07-11', 'kforce', ' Smith', 'smith@example.com', '123-456-7890', 'XYZ Partner', 'Client A', 60.00,
        'Confirmed', 'Contract', 'New York', 'NY', '12345'),
       (1, '2023-07-15', 'nyitho', 'John ', 'john@example.com', '123-456-7890', 'XYZ Partner', 'Client A', 70.00,
        'Pending', 'Contract', 'New York', 'NY', '12345'),
       (2, '2023-07-17', 'global soft', 'John Smith', 'john.smith@example.com', '123-456-7890', 'XYZ Partner',
        'Client A', null, 'Pending', 'Contract', 'New York', 'NY', '12345');

INSERT INTO submission_update (submission_id, update_text)
VALUES (4, 'Submission status updated to In Progress.');

-- 2.Write a SQL query to update email on the consultants table
UPDATE consultants
SET email = 'ajayreddy@gmail.com'
WHERE id = 1;

-- 3.Write a SQL to find total number of submissions for each constulant.
SELECT c.id,
       c.first_name,
       COUNT(s.id) AS total_submissions
FROM consultants c
         LEFT JOIN
     submissions s ON c.id = s.consultant_id
GROUP BY c.id, c.first_name;

-- 4.Write a SQL to find total number of submissions for each constulant by each submission day
SELECT c.id,
       c.first_name,
       s.submission_date,
       COUNT(s.id) AS total_submissions
FROM consultants c
         LEFT JOIN
     submissions s ON c.id = s.consultant_id
GROUP BY c.id, c.first_name, s.submission_date;

-- 5.write a SQL to delete all submissions where "rate" is null

DELETE
FROM submissions
WHERE pay_rate IS NULL;


-- 6.Given a lead name and submission date, Write a SQL query to find the submissions.

SELECT s.*
FROM submissions s
         JOIN
     consultants c ON s.consultant_id = c.id
         JOIN
     leads l ON c.lead_id = l.id
WHERE c.lead_id = 1
  AND s.technology = 'java';
-- SELECT s FROM Submission s JOIN Consultant c on s.consultant_id = c.id JOIN Lead l ON c.leadId=l.id

SELECT l.id        AS lead_id,
       l.first_name,
       COUNT(s.id) AS submission_count
FROM leads l
         LEFT JOIN
     consultants c ON l.id = c.lead_id
         LEFT JOIN
     submissions s ON c.id = s.consultant_id
GROUP BY l.id, l.first_name;


-- 1.created emp table
CREATE TABLE Employee
(
    first_name     VARCHAR(50),
    last_name      VARCHAR(50),
    job_start_date DATE,
    salary         DECIMAL(10, 2)
);

-- DDL command to add a new column "department"
ALTER TABLE Employee
    ADD COLUMN department VARCHAR(50);

INSERT INTO Employee (first_name, last_name, job_start_date, salary, department)
VALUES ('ajay', 'k', '2023-01-01', 7000.00, 'IT'),
       ('tejaswini', 'j', '2023-02-01', 5900.00, 'Teaching'),
       ('ravi', 'k', '2023-03-01', 6000.00, 'Data'),
       ('vijay', 'k', '2023-04-01', 6500.00, 'Sales');

-- SQL query to find the highest salary from an "Employee" table.
SELECT MAX(salary) AS highest_salary
FROM Employee;

-- query to find all the employees who joined in the last 6 months;

SELECT *
FROM Employee
WHERE job_start_date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH);


-- query display number of employees in each department.

SELECT department,
       COUNT(*) AS employee_count
FROM Employee
GROUP BY department;


