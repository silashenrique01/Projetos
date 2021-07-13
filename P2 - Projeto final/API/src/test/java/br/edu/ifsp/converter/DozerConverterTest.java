/*
 * package br.edu.ifsp.converter;
 * 
 * import java.util.List;
 * 
 * import org.junit.Before; import org.junit.Test; import org.junit.Assert;
 * 
 * import br.edu.ifsp.converter.mocks.MockPerson; import
 * br.edu.ifsp.data.model.Evento; import br.edu.ifsp.data.vo.v1.EventoVO;
 * 
 * public class DozerConverterTest {
 * 
 * MockPerson inputObject;
 * 
 * @Before public void setUp() { inputObject = new MockPerson(); }
 * 
 * @Test public void parseEntityToVOTest() { EventoVO output =
 * DozerConverter.parseObject(inputObject.mockEntity(), EventoVO.class);
 * Assert.assertEquals(Long.valueOf(0L), output.getKey());
 * Assert.assertEquals("First Name Test0", output.getFirstName());
 * Assert.assertEquals("Last Name Test0", output.getLastName());
 * Assert.assertEquals("Address Test0", output.getAddress());
 * Assert.assertEquals("Male", output.getGender()); }
 * 
 * @Test public void parseEntityToVOListTest() { List<EventoVO> outputList =
 * DozerConverter.parseListObjects(inputObject.mockEntityList(),
 * EventoVO.class); EventoVO outputZero = outputList.get(0);
 * 
 * Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
 * Assert.assertEquals("First Name Test0", outputZero.getFirstName());
 * Assert.assertEquals("Last Name Test0", outputZero.getLastName());
 * Assert.assertEquals("Address Test0", outputZero.getAddress());
 * Assert.assertEquals("Male", outputZero.getGender());
 * 
 * EventoVO outputSeven = outputList.get(7);
 * 
 * Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
 * Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
 * Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
 * Assert.assertEquals("Address Test7", outputSeven.getAddress());
 * Assert.assertEquals("Female", outputSeven.getGender());
 * 
 * EventoVO outputTwelve = outputList.get(12);
 * 
 * Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
 * Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
 * Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
 * Assert.assertEquals("Address Test12", outputTwelve.getAddress());
 * Assert.assertEquals("Male", outputTwelve.getGender()); }
 * 
 * @Test public void parseVOToEntityTest() { Evento output =
 * DozerConverter.parseObject(inputObject.mockVO(), Evento.class);
 * Assert.assertEquals(Long.valueOf(0L), output.getId());
 * Assert.assertEquals("First Name Test0", output.getFirstName());
 * Assert.assertEquals("Last Name Test0", output.getLastName());
 * Assert.assertEquals("Address Test0", output.getAddress());
 * Assert.assertEquals("Male", output.getGender()); }
 * 
 * @Test public void parseVOListToEntityListTest() { List<Evento> outputList =
 * DozerConverter.parseListObjects(inputObject.mockEntityList(), Evento.class);
 * Evento outputZero = outputList.get(0);
 * 
 * Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
 * Assert.assertEquals("First Name Test0", outputZero.getFirstName());
 * Assert.assertEquals("Last Name Test0", outputZero.getLastName());
 * Assert.assertEquals("Address Test0", outputZero.getAddress());
 * Assert.assertEquals("Male", outputZero.getGender());
 * 
 * Evento outputSeven = outputList.get(7);
 * 
 * Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
 * Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
 * Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
 * Assert.assertEquals("Address Test7", outputSeven.getAddress());
 * Assert.assertEquals("Female", outputSeven.getGender());
 * 
 * Evento outputTwelve = outputList.get(12);
 * 
 * Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
 * Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
 * Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
 * Assert.assertEquals("Address Test12", outputTwelve.getAddress());
 * Assert.assertEquals("Male", outputTwelve.getGender()); } }
 */