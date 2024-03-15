INSERT INTO address (street, city, state, zipCode) VALUES ('123 Main St', 'New York', 'NY', '10001');
INSERT INTO address (street, city, state, zipCode) VALUES ('456 Elm St', 'Los Angeles', 'CA', '90001');
INSERT INTO address (street, city, state, zipCode) VALUES ('789 Oak St', 'Chicago', 'IL', '60601');
INSERT INTO address (street, city, state, zipCode) VALUES ('101 Pine St', 'San Francisco', 'CA', '94101');
INSERT INTO address (street, city, state, zipCode) VALUES ('202 Maple St', 'Miami', 'FL', '33101');
INSERT INTO address (street, city, state, zipCode) VALUES ('303 Cedar St', 'Boston', 'MA', '02101');
INSERT INTO address (street, city, state, zipCode) VALUES ('404 Walnut St', 'Seattle', 'WA', '98101');
INSERT INTO address (street, city, state, zipCode) VALUES ('505 Birch St', 'Austin', 'TX', '78701');
INSERT INTO address (street, city, state, zipCode) VALUES ('606 Spruce St', 'Denver', 'CO', '80201');
INSERT INTO address (street, city, state, zipCode) VALUES ('707 Oak St', 'Orlando', 'FL', '32801');

INSERT INTO accommodation (address_id, number, price, detail) VALUES (1, 101, 150.00, 'Cozy apartment in downtown');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (2, 205, 200.00, 'Spacious house with a garden');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (3, 306, 180.00, 'Modern condo with city view');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (4, 408, 250.00, 'Luxurious penthouse in the heart of the city');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (5, 509, 300.00, 'Beachfront villa with private pool');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (6, 610, 180.00, 'Charming historic apartment near downtown');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (7, 712, 220.00, 'Modern loft with skyline view');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (8, 813, 190.00, 'Cozy cottage in a quiet neighborhood');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (9, 914, 170.00, 'Ski-in/ski-out cabin in the mountains');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (10, 1015, 280.00, 'Family-friendly resort near theme parks');

-- New accommodations for New York
INSERT INTO accommodation (address_id, number, price, detail) VALUES (1, 102, 160.00, 'Modern studio apartment in downtown');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (1, 103, 170.00, 'Cozy loft near Central Park');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (1, 104, 180.00, 'Chic penthouse with skyline view');

-- New accommodations for Los Angeles
INSERT INTO accommodation (address_id, number, price, detail) VALUES (2, 206, 220.00, 'Beach house with ocean view');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (2, 207, 240.00, 'Luxury villa with pool and spa');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (2, 208, 200.00, 'Modern apartment in Hollywood');

-- New accommodations for Chicago
INSERT INTO accommodation (address_id, number, price, detail) VALUES (3, 307, 190.00, 'Cozy apartment near Millennium Park');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (3, 308, 200.00, 'Downtown condo with lake view');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (3, 309, 180.00, 'Spacious loft in the Loop');

-- New accommodations for San Francisco
INSERT INTO accommodation (address_id, number, price, detail) VALUES (4, 409, 270.00, 'Luxury apartment with bay view');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (4, 410, 280.00, 'Penthouse with Golden Gate Bridge view');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (4, 411, 250.00, 'Charming Victorian house in Nob Hill');

-- New accommodations for Miami
INSERT INTO accommodation (address_id, number, price, detail) VALUES (5, 510, 320.00, 'Oceanfront condo with balcony');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (5, 511, 310.00, 'Luxurious beachfront apartment');
INSERT INTO accommodation (address_id, number, price, detail) VALUES (5, 512, 300.00, 'Miami Beach penthouse with private beach access');


-- Insert statements for airline
INSERT INTO airline (company_name, company_details) VALUES ('airline A', 'Providing excellent service since 1990');
INSERT INTO airline (company_name, company_details) VALUES ('airline B', 'Your reliable travel partner for over 50 years');
INSERT INTO airline (company_name, company_details) VALUES ('airline C', 'Fly with us for a comfortable journey');

-- Insert statements for route
INSERT INTO route (departure_id, arrival_id) VALUES (1, 2);
INSERT INTO route (departure_id, arrival_id) VALUES (2, 3);
INSERT INTO route (departure_id, arrival_id) VALUES (3, 1);

-- Insert statements for flight
INSERT INTO flight (number, departure, arrival, arrival_id, airline_id) VALUES (101, '2024-03-13 08:00:00', '2024-03-13 10:00:00', 1, 1);
INSERT INTO flight (number, departure, arrival, arrival_id, airline_id) VALUES (102, '2024-03-14 08:00:00', '2024-03-14 10:00:00', 2, 2);
INSERT INTO flight (number, departure, arrival, arrival_id, airline_id) VALUES (103, '2024-03-15 08:00:00', '2024-03-15 10:00:00', 3, 3);


INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (123, 456, 2, '2024-03-13 08:00:00', '2024-03-15 10:00:00', 200.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (789, 101112, 1, '2024-03-14 10:00:00', '2024-03-16 12:00:00', 150.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (131415, 161718, 3, '2024-03-15 12:00:00', '2024-03-17 14:00:00', 300.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (192021, 222324, 2, '2024-03-16 14:00:00', '2024-03-18 16:00:00', 250.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (252627, 282930, 1, '2024-03-17 16:00:00', '2024-03-19 18:00:00', 180.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (313233, 343536, 4, '2024-03-18 18:00:00', '2024-03-20 20:00:00', 400.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (373839, 404142, 2, '2024-03-19 20:00:00', '2024-03-21 22:00:00', 220.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (434445, 464748, 3, '2024-03-20 22:00:00', '2024-03-22 00:00:00', 300.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (495051, 525354, 1, '2024-03-21 00:00:00', '2024-03-23 02:00:00', 150.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (555657, 585960, 2, '2024-03-22 02:00:00', '2024-03-24 04:00:00', 250.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (616263, 646566, 1, '2024-03-23 04:00:00', '2024-03-25 06:00:00', 180.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (656667, 686970, 3, '2024-03-24 06:00:00', '2024-03-26 08:00:00', 300.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (717273, 747576, 2, '2024-03-25 08:00:00', '2024-03-27 10:00:00', 220.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (777879, 808182, 4, '2024-03-26 10:00:00', '2024-03-28 12:00:00', 400.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (838485, 868788, 2, '2024-03-27 12:00:00', '2024-03-29 14:00:00', 220.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (899091, 929394, 3, '2024-03-28 14:00:00', '2024-03-30 16:00:00', 300.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (959697, 9899100, 1, '2024-03-29 16:00:00', '2024-03-31 18:00:00', 150.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (101102103, 104105106, 2, '2024-03-30 18:00:00', '2024-04-01 20:00:00', 250.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (107108109, 110111112, 1, '2024-03-31 20:00:00', '2024-04-02 22:00:00', 180.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (113114115, 116117118, 3, '2024-04-01 22:00:00', '2024-04-03 00:00:00', 300.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (119120121, 122123124, 2, '2024-04-02 00:00:00', '2024-04-04 02:00:00', 220.00);
INSERT INTO booking (accommodation_id, flight_id, guest, booking_date, booking_end_date, total_amount) VALUES (125126127, 128129130, 4, '2024-04-03 02:00:00', '2024-04-05 04:00:00', 400.00);

