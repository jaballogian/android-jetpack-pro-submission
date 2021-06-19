# UNIT TESTING SCENARIOS

### Film View Model Test

1. Load a list of Movies:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

2. Load a list of TV Shows:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

### Detail View Model Test

1. Load the selected Movie data:
* Ensure that the data is not null
* Ensure that the data has the correct value

2. Load the selected TV Show data:
* Ensure that the data is not null
* Ensure that the data has the correct value

### Main Repository Test

1. Load a list of Movies:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

2. Load a list of TV Shows:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

3. Load the selected Movie data:
* Ensure that the data is not null
* Ensure that the data has the correct value

4. Load the selected TV Show data:
* Ensure that the data is not null
* Ensure that the data has the correct value

### Favorite Film View Model Test

1. Load a list of favorite Movies:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

2. Load a list of favorite TV Shows:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

### Favorite Detail View Model Test

1. Load the selected favorite Movie data:
* Ensure that the data is not null
* Ensure that the data has the correct value

2. Load the selected favorite TV Show data:
* Ensure that the data is not null
* Ensure that the data has the correct value

### Favorite Film Repository Test

1. Load a list of favorite Movies:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

2. Load a list of favorite TV Shows:
* Ensure that the list is not null
* Ensure that the list has the correct size/length

3. Load the selected favorite Movie data:
* Ensure that the data is not null
* Ensure that the data has the correct value

4. Load the selected favorite TV Show data:
* Ensure that the data is not null
* Ensure that the data has the correct value

# INSTRUMENTATION TESTING SCENARIOS

### Film Recycler View

1. Load Movies list data into recycler view:
* Ensure that the recycler view shows movies list data
* Scroll the recycler view into half of the list size/length item
* Scroll the recycler view into the last item

### Detail Activity

1. Load the first index film data from recycler view:
* Ensure that all dynamic text views in Detail Activity is shown
* Ensure that all dynamic text views in Detail Activity shows the correct data

2. Load the last index film data from recycler view:
* Ensure that all dynamic text views in Detail Activity is shown
* Ensure that all dynamic text views in Detail Activity shows the correct data

### Favorite Film Recycler View and Favorite Film Detail Activity

1. Load Movies list data into recycler view:
* Ensure that the recycler view shows movies list data
* Scroll and click the recycler view into the desired item
* Ensure that all dynamic text views in Detail Activity is shown
* Click the favorite (add to favorite list) button
* Click the favorite (go to Favorite Activity) button
* Ensure that favorite recycler view shows favorite movies list data
* Click the first item of favorite recycler view
* Ensure that all dynamic text views in Favorite Detail Activity is shown
* Click the trash (delete from favorite list) button
* Press the hardware back button
* Ensure that the list of movies is shown in Home Activity