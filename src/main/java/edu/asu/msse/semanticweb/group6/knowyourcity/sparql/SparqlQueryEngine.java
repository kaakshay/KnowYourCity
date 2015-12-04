package edu.asu.msse.semanticweb.group6.knowyourcity.sparql;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.jena.atlas.json.JsonObject;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

import edu.asu.msse.semanticweb.group6.knowyourcity.model.City;
import edu.asu.msse.semanticweb.group6.knowyourcity.model.Zipcode;

public class SparqlQueryEngine {

	static String defaultNameSpace = "http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#";
	private static SparqlQueryEngine instance = null;
	
	private static Model model = null;
	private static Model schema = null;

	public SparqlQueryEngine() {
		super();
		if (model == null) {
			populateOWLSchema();
			populateStateCityZip();
			populateHomeFair();
		}
	}

	private void populateOWLSchema() {
		try {
			InputStream inSchema = getClass().getResourceAsStream("/ontologies/know_your_city.owl");
			schema = ModelFactory.createOntologyModel();
			// Use local copy for demos without network connection
			schema.read(inSchema, defaultNameSpace);
			inSchema.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void populateStateCityZip() {
		model = ModelFactory.createOntologyModel();
		InputStream stateCityZip = getClass().getResourceAsStream("/ontologies/state-city-zip.rdf");
		model.read(stateCityZip, defaultNameSpace);
		try {
			stateCityZip.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void populateHomeFair() {
//		model = ModelFactory.createOntologyModel();
		InputStream inFoafInstance = getClass().getResourceAsStream("/ontologies/homefair.rdf");
		model.read(inFoafInstance, defaultNameSpace);
		try {
			inFoafInstance.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private StringBuffer prepareForQuery() {
		StringBuffer queryStr = new StringBuffer();
		City city = new City();
		// Establish Prefixes
		// Set default Name space first
		queryStr.append("PREFIX xsd" + ": <" + "http://www.w3.org/2001/XMLSchema#" + "> ");
		queryStr.append("PREFIX rdfs" + ": <" + "http://www.w3.org/2000/01/rdf-schema#" + "> ");
		queryStr.append("PREFIX rdf" + ": <" + "http://www.w3.org/1999/02/22-" + "rdf-syntax-ns#" + "> ");
		queryStr.append("PREFIX info" + ": <" + "http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city"
				+ "> ");

		return queryStr;
	}

	public List<Map> runGetCitiesForStateQuery(String statename) {
		List<Map> list = new ArrayList<Map>();
		StringBuffer queryStr = prepareForQuery();
		queryStr.append(
				"select ?name ?sub where{?sub <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#belongs_to_state> <http://127.0.0.1:3333/state/"
						+ statename.toLowerCase()
						+ ">. ?sub <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#has_name> ?name } ");
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		try {
			ResultSet response = qexec.execSelect();

			while (response.hasNext()) {
				QuerySolution soln = response.nextSolution();
				RDFNode name = soln.get("?name");
				RDFNode uri = soln.get("?sub");
				if (name != null) {
					Map map = new HashMap();
					map.put("uri",uri.toString());
					map.put("name", name.toString());
					list.add(map);
				}
			}
		} finally {
			qexec.close();
		}
		list.sort(new Comparator<Map>() {

			@Override
			public int compare(Map o1, Map o2) {
				String name1 =(String) o1.get("name");
				String name2 =(String) o2.get("name");
				return name1.compareTo(name2);
			}
			
		});
		return list;
	}

	public City runZipcodeInfoForCityUri(String cityuri) {
		Set<String> set = new HashSet<String>();
		StringBuffer queryStr = prepareForQuery();
		City city = new City();
		List<Zipcode> zipinfo = new ArrayList<Zipcode>();
		// Now add query
		queryStr.append("select ?zipcodename where {<" + cityuri
				+ "> <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#has_zipcodes> ?zipcode.?zipcode <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#is_a_zipcode> ?zipcodename.  }");
		// System.out.println(queryStr);
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		try {
			ResultSet response = qexec.execSelect();

			while (response.hasNext()) {
				QuerySolution soln = response.nextSolution();
				RDFNode name = soln.get("?zipcodename");
				if (name != null) {
					// System.out.println("Hello to " + name.toString());
					String[] splitname = name.toString().split("\\^");
					// System.out.println(splitname[0]);
					set.add(splitname[0]);

				}

			}
			for (String zipname : set) {

				zipinfo.add(runZipcodeInfo(zipname));
			}
			city.setZipcodes(zipinfo);
		} finally {
			qexec.close();
		}
		return city;

	}

	public Set<String> runGetStatesQuery() {
		Set<String> set = new TreeSet<String>();
		StringBuffer queryStr = prepareForQuery();

		queryStr.append(
				"select ?name where{?sub rdf:type <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#State>. ?sub <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#has_name> ?name } ");
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		try {
			ResultSet response = qexec.execSelect();

			while (response.hasNext()) {
				QuerySolution soln = response.nextSolution();
				RDFNode name = soln.get("?name");
				if (name != null) {
					// System.out.println("Hello to " + name.toString());
					set.add(name.toString());

				}
			}
		} finally {
			qexec.close();
		}
		return set;
	}

	public Zipcode runZipcodeInfo(String zip) {
		Zipcode zipcodeinfo = new Zipcode();
		StringBuffer queryStr = prepareForQuery();
		City city = new City();

		// Now add query
		queryStr.append(
				" select  ?median_time_to_work ?earthquake_risk ?air_pollution_index ?crime_risk where{<http://127.0.0.1:3333/zip_code/"
						+ zip
						+ "> <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#has_mean_transport_time> ?median_time_to_work."
						+ "<http://127.0.0.1:3333/zip_code/" + zip
						+ "> <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#has_air_pollution_index> ?air_pollution_index."
						+ "<http://127.0.0.1:3333/zip_code/" + zip
						+ "> <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#has_crime_risk> ?crime_risk."
						+ "<http://127.0.0.1:3333/zip_code/" + zip
						+ "> <http://www.semanticweb.org/japas_000/ontologies/2015/10/know-your-city#has_earthquake_risk> ?earthquake_risk.} ");
		Query query = QueryFactory.create(queryStr.toString());
		QueryExecution qexec = QueryExecutionFactory.create(query, model);

		try {
			ResultSet response = qexec.execSelect();
			// System.out.println(response);

			while (response.hasNext()) {
				QuerySolution soln = response.nextSolution();
				RDFNode mediantimetowork = soln.get("?median_time_to_work");
				RDFNode crimerisk = soln.get("?crime_risk");
				RDFNode earthquakerisk = soln.get("?earthquake_risk");
				RDFNode airpollutionindex = soln.get("?airpollution_index");

				if (mediantimetowork != null) {
					String[] test = mediantimetowork.toString().split("\\^");
					zipcodeinfo.setMedianTime(Double.parseDouble(test[0]));
				} else
					zipcodeinfo.setMedianTime(-1);
				if (crimerisk != null) {
					String[] test = crimerisk.toString().split("\\^");
					zipcodeinfo.setCrimeRisk((Double.parseDouble(test[0])));
				} else
					zipcodeinfo.setCrimeRisk(-1);
				if (earthquakerisk != null) {
					String[] test = earthquakerisk.toString().split("\\^");
					zipcodeinfo.setEarthquakeRisk((Double.parseDouble(test[0])));
				} else
					zipcodeinfo.setEarthquakeRisk(-1);
				if (airpollutionindex != null) {
					String[] test = airpollutionindex.toString().split("\\^");
					zipcodeinfo.setAirPollutionIndex((Double.parseDouble(test[0])));
				} else
					zipcodeinfo.setAirPollutionIndex(-1);
				zipcodeinfo.setZipcode(Integer.parseInt(zip));
			}
		} finally {
			qexec.close();
		}
		return zipcodeinfo;
	}

	public static void main(String[] args) {
		SparqlQueryEngine engine = new SparqlQueryEngine();
		Zipcode test = engine.runZipcodeInfo("85281");
		City city = engine.runZipcodeInfoForCityUri("http://127.0.0.1:3333/maricopa/phoenix");
		System.out.println(test.getZipcode());
		System.out.println(test.getAirPollutionIndex());
		System.out.println(test.getCrimeRisk());
		System.out.println(test.getMedianTime());
		System.out.println(test.getEarthquakeRisk());
	}
	
	public static SparqlQueryEngine getInstance(){
		if(instance == null)
			instance = new SparqlQueryEngine();
		return instance;
	}
}
