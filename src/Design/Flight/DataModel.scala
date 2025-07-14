package Design.Flight

object DataModel {

  case class Cities(id: Long, countryCode: String, cityName: String, cityCode: String)

  case class Flight(id: Long, name: String, airlineName: String, isPremiumFlight: Boolean, isActive: Boolean = true)

  case class OperatingFlight(id: Long, flightId: Long, cityFrom: Long, cityTo: Long, flightStartTime: Long, flightEndTime: Long)

  case class User(id: Long, name: String, phno: String, email: String)

  case class FareType(id: Long, fareClass: String, airLineName: String)

  case class Route(id: Long, fromCity: String, toCity: String)

  case class Fare(id: Long, routeId: Long, fareTypeId: Long, price: Double, validFrom: Option[Long] = None, validTo: Option[Long] = None)

}
