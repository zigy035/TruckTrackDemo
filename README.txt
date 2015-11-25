TODO:
1) Complete Cargo CRUD operations
2) Complete Vehicle CRUD operations
	* Autocomplete for field City
3) Create Admin panel:
	* List of customers, cargo, vehicle (CRUD)
	* CronJob (trigger) to check compatibility between cargo and vehicle offer
	* Configuration option:
		* Basic tab:	-Set records per page
						-Initial search results (none, last 7 days, unspecified)
		* List of Countries/cities/postcodes overview
		* Generate Cargo items
		* Generate Vehicle items 

4) Get resources (flags, City/postcode) and generate random data



Configuration
	recordsPerPage		int
	initSearchResult	enum (none, last 7 days, unspecified)
	
