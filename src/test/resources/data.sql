DROP TABLE IF EXISTS meteoseekers;

CREATE TABLE meteoseekers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) UNIQUE,
    location VARCHAR(250),
    firstinsert TIMESTAMP,
    lastinsert TIMESTAMP,
    temperatureincelsius DOUBLE,
    heatindexcelsius DOUBLE,
    temperatureinkelvin DOUBLE,
    heatindexkelvin DOUBLE,
    temperatureinfahrenheit DOUBLE,   
    heatindexfahrenheit DOUBLE,    
    humidity DOUBLE
);

INSERT INTO meteoseekers (name, location, firstinsert, lastinsert, temperatureincelsius, heatindexcelsius, temperatureinkelvin, heatindexkelvin, temperatureinfahrenheit, heatindexfahrenheit, humidity) VALUES
    ('Test1', 'test1', '2020-03-16 14:58:28', '2020-03-16 14:58:28', 10.00, 10.00, 12.00, 12.00, 13.00, 13.00, 14.00),
    ('Test2', 'test2', '2020-03-16 14:58:28', '2020-03-16 14:58:28', 15.00, 15.00, 16.00, 16.00, 17.00, 17.00, 18.00);
