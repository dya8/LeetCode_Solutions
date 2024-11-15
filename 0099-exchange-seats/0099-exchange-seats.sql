WITH max_cte AS (
	SELECT 
		MAX(Id) AS max_id 
	FROM Seat
)
SELECT 
   IF(Id < (SELECT max_id FROM max_cte), 
		IF(Id%2 = 1, Id+1, Id-1), 
		IF(Id%2 = 1, Id, Id-1)
	 ) AS id,
   student
FROM Seat
ORDER BY Id;