SELECT 
    *
FROM
    planes.trip;

-- SELECT #9  
SELECT 
    trip.trip_no,
    company.name,
    trip.town_from,
    trip.town_to,
    CASE
        WHEN TIMEDIFF(time_in, time_out) < 0 THEN TIMEDIFF(time_out, time_in)
        ELSE TIMEDIFF(time_in, time_out)
    END AS duration
FROM
    trip
        INNER JOIN
    company ON trip.ID_comp = company.ID_comp
