/*
 * package br.edu.ifsp.converter.mocks;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import br.edu.ifsp.data.model.Evento; import br.edu.ifsp.data.vo.v1.EventoVO;
 * 
 * public class MockPerson {
 * 
 * public Evento mockEntity() { return mockEntity(0); }
 * 
 * public EventoVO mockVO() { return mockVO(0); }
 * 
 * public List<Evento> mockEntityList() { List<Evento> persons = new
 * ArrayList<Evento>(); for(int i = 0; i < 14; i++) {
 * persons.add(mockEntity(i)); } return persons; }
 * 
 * public List<EventoVO> mockVOList() { List<EventoVO> persons = new
 * ArrayList<>(); for(int i = 0; i < 14; i++) { persons.add(mockVO(i)); } return
 * persons; }
 * 
 * private Evento mockEntity(Integer number) { Evento person = new Evento();
 * person.setAddress("Address Test" + number);
 * person.setFirstName("First Name Test" + number); person.setGender(((number %
 * 2)==0) ? "Male" : "Female"); person.setId(number.longValue());
 * person.setLastName("Last Name Test" + number); return person; }
 * 
 * private EventoVO mockVO(Integer number) { EventoVO person = new EventoVO();
 * person.setAddress("Address Test" + number);
 * person.setFirstName("First Name Test" + number); person.setGender(((number %
 * 2)==0) ? "Male" : "Female"); person.setKey(number.longValue());
 * person.setLastName("Last Name Test" + number); return person; } }
 */