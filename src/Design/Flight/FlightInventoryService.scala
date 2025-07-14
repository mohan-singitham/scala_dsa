package Design.Flight

class FlightInventoryService extends App {

  // connect to DB and convert them to Flight case class
  val flights = List(DataModel.Flight(1, "6E-123", "Air India", true),
    DataModel.Flight(2, "6E-124", "Air India", true),
    DataModel.Flight(3, "6E-125", "Air India", true),
    DataModel.Flight(4, "IN-123", "SpiceJet", true),
    DataModel.Flight(5, "IN-124", "SpiceJet", true),
    DataModel.Flight(6, "IN-125", "SpiceJet", true),
    DataModel.Flight(7, "IND-124", "Indigo", true),
    DataModel.Flight(8, "IND-125", "Indigo", true))

  val flightService = new FlightService(flights)

  val cities = List(Cities(1, "IN", "Hyderabad", "HYD"),
    Cities(2, "IN", "Bangalore", "BGL"),
    Cities(3, "IN", "Delhi", "DEL"))

  val operatingFlights = List(OperatingFlight(1, 1, 1, 2, System.currentTimeMillis(), System.currentTimeMillis() + 4 * 60 * 60 * 1000),
    OperatingFlight(2, 4, 1, 2, System.currentTimeMillis(), System.currentTimeMillis() + 4 * 60 * 60 * 1000)
  )

  val operatingFlightsService = new OperatingFlightService(operatingFlights)

  val allFareTypes = List(FareType(1, "Economy", "Air India"),
    FareType(2, "First Class", "Air India"),
    FareType(3, "Economy", "SpiceJet"),
    FareType(4, "First Class", "SpiceJet"))

  val allRoutes = List(
    Route(1, "HYD", "DEL"),
    Route(2, "HYD", "BGL")
  )

  val fares = List(
    Fare(1, 1, 1, 3200),
    Fare(2, 1, 4, 6000),
  )

  val fareServiceImpl = new FareService(allFareTypes, allRoutes, fares)

  fareServiceImpl.getFares("HYD", "BGL")
}
