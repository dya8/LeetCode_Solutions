# Write your MySQL query statement below
SELECT v.customer_id, count(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id; /*we are using group by inorder to get count of each individual customer
else we will get the count of all the all rows which matches the condition and will be a single value*/