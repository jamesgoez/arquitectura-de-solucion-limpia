create table notification
(
	id						serial primary key,
	buyer_email 			text,
	latitude   		        DECIMAL,
	longitude   		    DECIMAL,
	forecast_code   		integer,
	forecast_description    text,
	buyer_notification      boolean,
	creation_date			timestamp without time zone
);