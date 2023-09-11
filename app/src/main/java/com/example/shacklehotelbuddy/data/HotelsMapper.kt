package com.example.shacklehotelbuddy.data

import com.example.shacklehotelbuddy.ext.orZero
import com.example.shacklehotelbuddy.model.Hotels
import com.example.shacklehotelbuddy.model.Properties

class HotelsMapper {

    fun map(remoteHotelsResponse: List<Properties>?): List<Hotels> {

        return listOf<Hotels>(
            Hotels(
                title = "Vesna Hotel",
                subtitle = "Vienna, Austria",
                description = "$ 100 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Radisson Blu Resort Cam Ranh",
                subtitle = "Am",
                description = "$ 300 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/38000000/38000000/37999200/37999130/3b7916ce.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.0
            ),
            Hotels(
                title = "Mövenpick Resort Cam Ranh",
                subtitle = "Ameterdem, Netherlands",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/41000000/40470000/40460600/40460567/06e493b7.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Sun Villa",
                subtitle = "Abu Dhabi, UAE",
                description = "$ 50 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/64000000/63510000/63505200/63505151/6100fcf6.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "D26 Nha Trang Hotel",
                subtitle = "Berlin, Germany",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/19000000/18910000/18907300/18907213/42d297d6.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 5.0
            ),
            Hotels(
                title = "Alpha Bird Nha Trang",
                subtitle = "Islamabad, Pakistan",
                description = "$ 40 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/42000000/41190000/41182500/41182444/9a0e8c62.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Alibu Resort Nha Trang",
                subtitle = "Heague, Netherlands",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Whale Island Resort",
                subtitle = "London, England",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/5000000/4760000/4757600/4757569/fdecba1e.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Hon Tam Resort",
                subtitle = "Bangkok, Thailand",
                description = "$ 50 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/3000000/2550000/2540800/2540761/7481b1b9.jpg?impolicy=resizecrop&rw=455&ra=fit\"",
                rating = 4.5
            ),
            Hotels(
                title = "Diamond Bay Resort and Spa",
                subtitle = "Rome, Italy",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/3000000/2470000/2461700/2461647/b95530b2.jpg?impolicy=resizecrop&rw=455&ra=fit\"",
                rating = 4.5
            ),
            Hotels(
                title = "Alma Resort Cam Ranh",
                subtitle = "Madrid, Spain",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/46000000/45780000/45773100/45773013/66bb5a8a.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Vesna Hotel",
                subtitle = "Am",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Vesna Hotel",
                subtitle = "Am",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Vesna Hotel",
                subtitle = "Am",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Vesna Hotel",
                subtitle = "Am",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Vesna Hotel",
                subtitle = "Am",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Vesna Hotel",
                subtitle = "Am",
                description = "$ 200 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/34000000/33340000/33331400/33331379/e8f3f926.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Seaside Hotel 2",
                subtitle = "Sea South Hall",
                description = "$ 800 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/10000000/9310000/9308200/9308177/6b72e0bc.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            ),
            Hotels(
                title = "Aquatic Ocean Hotel",
                subtitle = "Rio, Brazil",
                description = "$ 300 per night",
                largeImageURL = "https://images.trvl-media.com/lodging/20000000/19530000/19527200/19527132/393a453a.jpg?impolicy=resizecrop&rw=455&ra=fit",
                rating = 4.5
            )
        )
    }
}