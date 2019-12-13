![Picture](https://github.com/bhern154/bhern154.github.io/blob/master/banner.jpg)

# Weather Buddy Android App

A weather app with virtual pet to keep you company!

What we used for our app:
* Weather API
* Linear Constraints
* Image View with vectors to display our character


# Dean

### Tasks:
 * Find free weather API
 * Implement API in our Android app
 * Learn how to call for data from API for us to display

# Brian

### Tasks:
* Design app character (Buddy)
* Create app design (Main Fragment)
* Find wallpapers to use with app for different times of the day
* Find icons to use for app conditions

### The Character Design:
<div>
<img src="https://github.com/bhern154/bhern154.github.io/blob/master/bear_logo.png" width="30%" style="float: left">
<img src="https://github.com/bhern154/bhern154.github.io/blob/master/buddy_logo_umbrella.png" width="40%" style="float: left">
</div>

<br>
I created this with objects using Adobe Illustrator
<br>
Goal with virtual character: 

* We wanted to make our app different from the other weather apps
* Character should move around (When it rains, takes out umbrella)
* Character should give you information about the day

I did not have time to animate the character

### The Wallpapers for Day-Times:

<img src="https://github.com/bhern154/bhern154.github.io/blob/master/8_bit_day.png" width="80%">
<br>
These 8 images change depending on the time of the day. 
<br>

### Icons:
<img src="https://github.com/bhern154/bhern154.github.io/blob/master/weather_icons.png" width="80%">
<br>
The weather icons should change depending on the weather condition returned by the API. 
<br>

### App Design:



<br>
Information displayed from API:
* Current weather (Degrees in fahrenheit)
* Min/max weather in the day
* Current weather conditions (Sunny, rainy, windy)
<br>
It has a textClock to display the clock in real time.


# Ashley

### Tasks:
 * Vectorize the character to display on app
 * Have the character adapt to the weather (Changes color and state)
 * Have the wallpaper adapt to the time of day 
 * Have the icons adapt to weather conditions
 
 <img src="https://raw.githubusercontent.com/ajetty/Images/master/BearAnimate.gif">
 
 ### Custom ImageView
 
 ### Array Map
 
 ### ViewModel
 
 <img src="https://github.com/ajetty/Images/blob/master/mvvm.png">
 

# Margarita

### Tasks:
 * Create settings fragment to update/change the city
 * Have the user input update the location for the API
 * Have API update the weather conditions
 
The settings can be accessed by clicking on the top settings icon located at the top left hand side of the screen.
<img src="https://raw.githubusercontent.com/MargaritaNuridj/MargaritaNuridj.github.io/master/images/icons8-settings-64.png">

The settings page is responisble for changing the location used in the app. 

If a location is valid it will change the location on the homepage. 
<img src="https://raw.githubusercontent.com/MargaritaNuridj/MargaritaNuridj.github.io/master/images/Screen%20Shot%202019-12-13%20at%2012.53.50%20AM.png">

If the location is not valid, or blank the location will remain the same as the previous location, and error message will also display on the settings screen telling you if the location is invalid and asking you to refer to all the valid locations located at the openweather api website. 

<img src="https://raw.githubusercontent.com/MargaritaNuridj/MargaritaNuridj.github.io/master/images/Screen%20Shot%202019-12-13%20at%2012.54.10%20AM.png">



## Getting Started

clone the project:

```
git clone 
```

### Prerequisites

```
Download Android Studio 
```
https://developer.android.com/

```
Download Java Development Kit
```
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html



### Installing

```
Install Android studio
Install JDK
```

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
