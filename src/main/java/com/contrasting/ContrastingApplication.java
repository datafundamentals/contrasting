package com.contrasting;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.contrasting.model.Attitude;
import com.contrasting.model.Deployment;
import com.contrasting.model.Metric;
import com.contrasting.model.Note;
import com.contrasting.model.Skill;
import com.contrasting.model.Task;
import com.contrasting.model.TeamMember;
import com.contrasting.random.RandomParagraph;
import com.contrasting.random.RandomProvider;
import com.contrasting.random.RandomSentence;
import com.contrasting.random.RandomWord;
import com.contrasting.repository.AttitudeRepository;
import com.contrasting.repository.DeploymentRepository;
import com.contrasting.repository.MetricRepository;
import com.contrasting.repository.NoteRepository;
import com.contrasting.repository.SkillRepository;
import com.contrasting.repository.TaskRepository;
import com.contrasting.repository.TeamMemberRepository;

@SpringBootApplication
public class ContrastingApplication {
	private static final Logger log = LoggerFactory.getLogger(ContrastingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ContrastingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AttitudeRepository attitudeRepository, DeploymentRepository deploymentRepository,
			MetricRepository metricRepository, NoteRepository noteRepository, SkillRepository skillRepository,
			TaskRepository taskRepository, TeamMemberRepository teamMemberRepository) {
		return (args) -> {
			log.info("-------------------------------START POPULATING DATABASE");
			long attitudeCount = attitudeRepository.count();
			long deploymentCount = deploymentRepository.count();
			long metricCount = metricRepository.count();
			long noteCount = noteRepository.count();
			long skillCount = skillRepository.count();
			long taskCount = taskRepository.count();
			long teamMemberCount = teamMemberRepository.count();
			int desired = 0;
			desired = 6;
			if (attitudeCount == 0) {
				initAttitude(attitudeRepository, desired);
			} else if (deploymentCount < desired) {
				fluffAttitude(attitudeRepository, desired);
			}
			desired = 6;
			if (deploymentCount == 0) {
				initDeployment(deploymentRepository, desired);
			} else if (deploymentCount < desired) {
				fluffDeployment(deploymentRepository, desired);
			}
			desired = 13;
			if (metricCount == 0) {
				initMetric(metricRepository, desired);
			} else if (deploymentCount < desired) {
				fluffMetric(metricRepository, desired);
			}
			desired = 24;
			if (noteCount == 0) {
				initNote(noteRepository, desired);
			} else if (deploymentCount < desired) {
				fluffNote(noteRepository, desired);
			}
			desired = 37;
			if (skillCount == 0) {
				initSkill(skillRepository, desired);
			} else if (deploymentCount < desired) {
				fluffSkill(skillRepository, desired);
			}
			desired = 41;
			if (taskCount == 0) {
				initTask(taskRepository, desired);
			} else if (deploymentCount < desired) {
				fluffTask(taskRepository, desired);
			}
			desired = 56;
			if (teamMemberCount == 0) {
				initTeamMember(teamMemberRepository, desired);
			} else if (deploymentCount < desired) {
				fluffTeamMember(teamMemberRepository, desired);
			}
			// Iterable<Customer> customers = attitudeRepository.findAll();
			// for (int i = 0; i + customerCount < 100; customerCount++) {
			// Customer customer = new Customer(RandomProvider.randomName(),
			// StringUtils_.randomString(3, false),
			// "STANDARD");
			// customerRepository.save(customer);
			// }
			// log.info("-------------------------------DONE POPULATING customer
			// WITH " + customerCount);
			// for (int i = 0; i + projectPhaseCount < 14; projectPhaseCount++)
			// {
			// ProjectPhase projectPhase = new
			// ProjectPhase(RandomWord.getWord(), RandomSentence.getSentence(),
			// StringUtils_.randomString(4, false).toUpperCase());
			// projectPhaseRepository.save(projectPhase);
			// }
			// log.info("-------------------------------DONE POPULATING
			// projectPhase WITH " + projectPhaseCount);
			// for (int i = 0; i + scoreKeyCount < 25; scoreKeyCount++) {
			// ScoreKey scoreKey = new ScoreKey(RandomWord.getWord(),
			// RandomSentence.getSentence(),
			// StringUtils_.randomString(6, false).toUpperCase());
			// scoreKeyRepository.save(scoreKey);
			// }
			// log.info("-------------------------------DONE POPULATING scoreKey
			// WITH " + scoreKeyCount);
			// for (int i = 0; i + scoreMungerCount < 25; scoreMungerCount++) {
			// ScoreMunger scoreMunger = new ScoreMunger(
			// StringUtils_.upLow(RandomWord.getWord()) + " " +
			// StringUtils_.upLow(RandomWord.getWord()),
			// RandomSentence.getSentence(),
			// StringUtils_.randomString(3, false).toUpperCase());
			// scoreMungerRepository.save(scoreMunger);
			// }
			// log.info("-------------------------------DONE POPULATING
			// scoreMunger WITH " + scoreMungerCount);
			// for (int i = 0; i + sideEffectCount < 140; sideEffectCount++) {
			// SideEffect sideEffect = new SideEffect(RandomWord.getWord() + " "
			// + RandomWord.getWord(),
			// RandomSentence.getSentence(), StringUtils_.randomString(3,
			// false).toUpperCase(), false, true,
			// true, false, RandomWord.getWord(), RandomWord.getWord());
			// sideEffectRepository.save(sideEffect);
			// }
			// log.info("-------------------------------DONE POPULATING
			// sideEffect WITH " + sideEffectCount);
			// for (int i = 0; i + taskCount < 300; taskCount++) {
			// int startDay = (int) (Math.random() * 150);
			// int durationHours = (int) (Math.random() * 150);
			// Task task = new Task(StringUtils_.upLow(RandomWord.getWord()) + "
			// " + RandomWord.getWord(),
			// RandomSentence.getSentence(), StringUtils_.randomString(3,
			// false).toUpperCase(), startDay,
			// durationHours, RandomWord.getWord());
			// taskRepository.save(task);
			// }
			// log.info("-------------------------------DONE POPULATING task
			// WITH " + taskCount);
			// for (int i = 0; i + teamInventoryCount < 50;
			// teamInventoryCount++) {
			// int choice = (int) (Math.random() * 16);
			// int topRange = (int) (Math.random() * 150);
			// int bottomRange = (int) (Math.random() * 10);
			// String text = RandomParagraph.getParagraph();
			// if(text.length()>250){
			// text = text.substring(0,250)+ ".";
			// }
			// TeamInventory teamInventory = new
			// TeamInventory(RandomWord.getWord().toUpperCase(),
			// StringUtils_.upLow(RandomWord.getWord()),
			// RandomSentence.getSentence(), choice,
			// RandomWord.getWord(), topRange, bottomRange, text);
			// teamInventoryRepository.save(teamInventory);
			// }
			// log.info("-------------------------------DONE POPULATING
			// teamInventory WITH " + teamInventoryCount);
			// for (int i = 0; i + technologyGroupCount < 40;
			// technologyGroupCount++) {
			// TechnologyGroup technologyGroup = new
			// TechnologyGroup(RandomWord.getWord().toUpperCase(),
			// RandomSentence.getSentence(), StringUtils_.randomString(4,
			// false).toUpperCase());
			// technologyGroupRepository.save(technologyGroup);
			// }
			// log.info("-------------------------------DONE POPULATING
			// technologyGroup WITH " + technologyGroupCount);
			// for (int i = 0; i + technologyCount < 100; technologyCount++) {
			// Technology technology = new Technology(
			// StringUtils_.upLow(RandomWord.getWord()) + " " +
			// RandomWord.getWord(),
			// RandomSentence.getSentence(), StringUtils_.randomString(3,
			// false).toUpperCase());
			// technologyRepository.save(technology);
			// }
			// log.info("-------------------------------DONE POPULATING
			// technology WITH " + technologyCount);
			// for (int i = 0; i + workerCount < 100; workerCount++) {
			// String name = org.btrg.utils.random.RandomProvider.randomName();
			// Worker worker = new Worker(name.substring(0, name.indexOf(" ")),
			// name.substring(name.indexOf(" "), name.length() - 1),
			// RandomWord.getWord(), "Chicago",
			// StringUtils_.randomNumberString(10),
			// StringUtils_.randomString(9, true).toLowerCase() + "@" +
			// StringUtils_.randomString(6, false).toLowerCase() + ".com");
			// workerRepository.save(worker);
			// }
			// log.info("-------------------------------DONE POPULATING worker
			// WITH" + workerCount);
			// log.info("-------------------------------DONE POPULATING
			// DATABASE");
		};
	}

	private void fluffTeamMember(TeamMemberRepository teamMemberRepository, int desired) {
		long teamMemberCount = teamMemberRepository.count();
		for (int i = 0; i + teamMemberCount < desired; teamMemberCount++) {
			TeamMember teamMember = new TeamMember(RandomProvider.randomName(), RandomWord.getWord());
			teamMemberRepository.save(teamMember);
		}
		log.info("-------------------------------DONE POPULATING teamMember WITH " + desired);
	}

	private void initTeamMember(TeamMemberRepository teamMemberRepository, int desired) {
		TeamMember teamMember = null;
		String name = "Steve Feldman";
		String role = "VP";
		teamMember = new TeamMember(name, role);
		teamMemberRepository.save(teamMember);
		name = "David Hafley";
		role = "Dragon Slayer";
		teamMember = new TeamMember(name, role);
		teamMemberRepository.save(teamMember);
		name = "Pete Carapetyan";
		role = "opinionated teammate";
		teamMember = new TeamMember(name, role);
		teamMemberRepository.save(teamMember);
		fluffTeamMember(teamMemberRepository, desired);
	}

	private void fluffTask(TaskRepository taskRepository, int desired) {
		long taskCount = taskRepository.count();
		for (int i = 0; i + taskCount < desired; taskCount++) {
			Task task = new Task(RandomWord.getWord(), RandomWord.getWord(), (long) Math.random() * 500);
			taskRepository.save(task);
		}
		log.info("-------------------------------DONE POPULATING task WITH " + desired);
	}

	private void initTask(TaskRepository taskRepository, int desired) {
		Task task = null;
		String name = null;
		String area = null;
		long teamMemberId = (long) Math.random();
		name = "java";
		area = "development";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "java";
		area = "architecture";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "data modeling";
		area = "relational";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "data modeling";
		area = "non-relational";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "automation";
		area = "configuration management";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "automation";
		area = "containers";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "automation";
		area = "templating";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "automation";
		area = "api design";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "CI/CD";
		area = "pipelines";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "CI/CD";
		area = "tooling";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "CI/CD";
		area = "expertise";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "CI/CD";
		area = "metrics, perspective";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "CI/CD";
		area = "passion";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "CI/CD";
		area = "Teaching To Fish";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "Linux";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "Tomcat";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "nginx";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "MySQL";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "ActiveMQ";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "Cassandra";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "kafka";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "admin";
		area = "logging";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		name = "desire";
		area = "make internet a safer place";
		teamMemberId = (long) Math.random();
		task = new Task(name, area, teamMemberId);
		taskRepository.save(task);
		// name = "";
		// area = "";
		// teamMemberId = (long) Math.random();
		// task = new Task(name, area, teamMemberId);
		// taskRepository.save(task);
		fluffTask(taskRepository, desired);
	}

	private void fluffSkill(SkillRepository skillRepository, int desired) {
		long skillCount = skillRepository.count();
		for (int i = 0; i + skillCount < desired; skillCount++) {
			Skill skill = new Skill(RandomWord.getWord(), (int) Math.random() * 10, false);
			;
			skillRepository.save(skill);
		}
		log.info("-------------------------------DONE POPULATING skill WITH " + desired);
	}

	private void initSkill(SkillRepository skillRepository, int desired) {
		Skill skill = null;
		String name = null;
		int level = 0;
		boolean required = false;
		name = "java";
		level = 9;
		required = true;
		skill = new Skill(name, level, required);
		skillRepository.save(skill);
		name = "mysql";
		level = 5;
		required = true;
		skill = new Skill(name, level, required);
		skillRepository.save(skill);
		name = "cassandra";
		level = 3;
		required = false;
		skill = new Skill(name, level, required);
		skillRepository.save(skill);
		name = "kafka";
		level = 3;
		required = true;
		skill = new Skill(name, level, required);
		skillRepository.save(skill);
		name = "automation design";
		level = 8;
		required = true;
		skill = new Skill(name, level, required);
		skillRepository.save(skill);
		fluffSkill(skillRepository, desired);
	}

	private void fluffNote(NoteRepository noteRepository, int desired) {
		long noteCount = noteRepository.count();
		for (int i = 0; i + noteCount < desired; noteCount++) {
			Note note = new Note(RandomSentence.getSentence(), RandomParagraph.getParagraph());
			;
			noteRepository.save(note);
		}
		log.info("-------------------------------DONE POPULATING note WITH " + desired);
	}

	private void initNote(NoteRepository noteRepository, int desired) {
		Note note = null;
		String content = null;
		String category = null;
		content = "Some of my admin skills are moderate at best";
		category = "admin";
		note = new Note(content, category);
		noteRepository.save(note);
		content = "Intolerance can be tempered with more graceful skills. I am not as big a believer in intolerance as I used to be. There are more effective means of acheiving the same objectives, most notably by modeling more effective approaches.";
		category = "interpersonal";
		note = new Note(content, category);
		noteRepository.save(note);
		content = "Perfection is the enemy of excellence, except in certain situations - such as some aspects of security";
		category = "approach";
		note = new Note(content, category);
		noteRepository.save(note);
		content = "Challenging conventional wisdom, like intolerance, requires finess and grace. I began my career without either.";
		category = "experience";
		note = new Note(content, category);
		noteRepository.save(note);
		content = "Full stack, full cycle. Slow cycles often cover a multitude of sins. Enabling fast cycles enables quality improvements that would not be conceivable at slower cycle time rates.";
		category = "speed";
		note = new Note(content, category);
		noteRepository.save(note);
		// content = "";
		// category = "";
		// note = new Note(content, category);
		// noteRepository.save(note);
		fluffNote(noteRepository, desired);
	}

	private void fluffMetric(MetricRepository metricRepository, int desired) {
		long metricCount = metricRepository.count();
		for (int i = 0; i + metricCount < desired; metricCount++) {
			Metric metric = new Metric(RandomWord.getWord(), (long) Math.random() * 200);
			;
			metricRepository.save(metric);
		}
		log.info("-------------------------------DONE POPULATING metric WITH " + desired);

	}

	private void initMetric(MetricRepository metricRepository, int desired) {
		Metric metric = null;
		String name = null;
		long categoryId = 0;
		name = "consistent";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "explicit";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "transparency";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "instantaneous";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "obvious";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "tooled";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "design";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "concise";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "regression tested";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		name = "load tested";
		categoryId = (long) Math.random() * 17;
		metric = new Metric(name, categoryId);
		// name = "";
		// categoryId = (long) Math.random()*17;
		// metric = new Metric(name, categoryId);
		fluffMetric(metricRepository, desired);
	}

	private void fluffAttitude(AttitudeRepository attitudeRepository, int desired) {
		long attitudeCount = attitudeRepository.count();
		for (int i = 0; i + attitudeCount < desired; attitudeCount++) {
			Attitude attitude = new Attitude(RandomWord.getWord(), RandomSentence.getSentence(),
					(int) Math.random() * 10);
			;
			attitudeRepository.save(attitude);
		}
		log.info("-------------------------------DONE POPULATING attitude WITH " + desired);

	}

	private void initAttitude(AttitudeRepository attitudeRepository, int desired) {
		Attitude attitude = null;
		String trait = null;
		String descrip = null;
		int minimum = 0;
		trait = "humility";
		descrip = "As contrasting with hubris - the ability to work with eyes and ears wide open, not missing important details just because I know it all.";
		minimum = 3;
		attitude = new Attitude(trait, descrip, minimum);
		attitudeRepository.save(attitude);
		trait = "courage";
		descrip = "Willingness to step beyond my comfort zone, especially as relates to quick experiments that may yeild more effective approaches.";
		minimum = 7;
		attitude = new Attitude(trait, descrip, minimum);
		attitudeRepository.save(attitude);
		trait = "zone";
		descrip = "The ability to get in the zone and work through a problem is an attitude, more than just some kind of miraculous tendency.";
		minimum = 8;
		attitude = new Attitude(trait, descrip, minimum);
		attitudeRepository.save(attitude);
		trait = "mathematical";
		descrip = "In younger years, I thought in terms that did not include probabilities, and the 'set' of possible outcomes was much smaller and more artificial.";
		minimum = 0;
		attitude = new Attitude(trait, descrip, minimum);
		attitudeRepository.save(attitude);
		trait = "consensus";
		descrip = "My adult children have taught me that consensus and working with others trumps the heck out of my authoritarian roots. This is knowledge that I cherish and enjoy exploring. It bears immediate fruit, and it is fun to watch it unfold.";
		minimum = 0;
		attitude = new Attitude(trait, descrip, minimum);
		attitudeRepository.save(attitude);
		// trait = "";
		// descrip = "";
		// minimum = 0;
		// attitude = new Attitude(trait, descrip, minimum);
		// attitudeRepository.save(attitude);
		fluffAttitude(attitudeRepository, desired);
	}

	private void fluffDeployment(DeploymentRepository deploymentRepository, int desired) {
		long deploymentCount = deploymentRepository.count();
		for (int i = 0; i + deploymentCount < desired; deploymentCount++) {
			Deployment deployment = new Deployment(RandomWord.getWord(), RandomWord.getWord());
			;
			deploymentRepository.save(deployment);
		}
		log.info("-------------------------------DONE POPULATING deployment WITH " + desired);
	}

	private void initDeployment(DeploymentRepository deploymentRepository, int desired) {
		Deployment deployment = null;
		String name = null;
		String language = null;
		name = "Vagrant";
		language = "Ruby";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "script";
		language = "Bash";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "Chef";
		language = "Ruby";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "Gradle";
		language = "Groovy";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "Maven";
		language = "Groovy";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "Jenkins";
		language = "xml";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "Docker";
		language = "...";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "MySQL";
		language = "SQL";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "ActiveMQ";
		language = "Java";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		name = "Tomcat";
		language = "xml";
		deployment = new Deployment(name, language);
		deploymentRepository.save(deployment);
		// name = "";
		// language = "";
		// deployment = new Deployment(name, language);
		// deploymentRepository.save(deployment);
		fluffDeployment(deploymentRepository, desired);
	}
}
