# web-crawler
a web crawler that iteratively extracts links form a webpage and give you most relevant results. Contains an integrated display window to visit the webpage.

Here we need to crawl a webpage for a keyword before hand to populate the database with the results, Later these results are shown when you search for that keyword.
You have manual as well as automatic crawl option.
In manual crawl your are supposed to give the seed site along with the keyword.
In auto crawl only keyword need to be given provided that your data base has some site related to that keyword, our crawler automatically fetches that site from the database as the seed site.
need to create a database name info and table frontier, 
table frontier has the following entries:

site - varchar (unique)

tag - varchar

hits - integer

to access admin module
password admin
username admin

crawl the page first to get the crawled results in the search.
